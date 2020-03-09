# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket
import logging
import threading
import json
import helpers.IpDecode as decode
import psutil


"""
Server IP Address Handler
~~~~~~~~~~~~~~~~~~~

A Simple IP Address Handler written in Python, for human beings.
usage:
>>> readConfig-> Gets Client Ip address  prints it out

>>> setServerIP() -> gets Ip to Server Via Function
"""

# Logging for Ips
logging.basicConfig(filename='Ip.log', level=logging.DEBUG)

# reads Loaded Json Config

online = []
offline = []
port = []
listen = []
# Sets Server Ip and Port
server_ip = ''
server_port = ''


def readConfig():
    global online
    global offline
    global server_port

    logging.info("config loading")

    # reads ServerConfig
    with open("ServerConfig.json", "r") as read_it:
        data = json.load(read_it)

    # Grabs mode from json
    online = data['online']
    offline = data['offline']
    port = data['port']

    logging.info("Loaded server mode \n")


def getServerIP():

    global online
    global offline
    global listen
    global server_ip
    global server_port

    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.connect(("8.8.8.8", 80))
        # Sets local ip adress for server
        IPAddr = s.getsockname()[0]

    except socket.gaierror as error:
        logging.fatal("there was an error resolving the host" + error)

    s.close()

    hostname = socket.gethostname()

    ip = (requests.get('https://checkip.amazonaws.com').text.lower())

    # Logs out Your Server Public Ip Server Host name and Your Local Network Ip
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    logging.debug("Your publicIp" + ip)
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    logging.debug("Your Computer Name is:" + hostname)
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    logging.debug("Your Computer IP Address is:" + IPAddr)
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    if (online == True):
        logging.info("User Set Server to Be ONLINE Mode")
        # Sets Server Ip To your Public Ip address
        server_ip = ip

        logging.info("Set Server Ip to " + server_ip)

        logging.debug("serverThread started")
        # threads server
        server_thread = threading.Thread.start(
            target=startServerOnline(server_ip))

        # Starts Server With Your Public ip
        server_thread.start()

        # cleanly Exits out of online server
        if (exit(0)):
            server_thread.join()
            usage.Quit()
            logging.warning("Python Quit Cleanly ")

    elif (offline == True):
        logging.info("User Set Server to Be OFFLINE Mode")

        logging.debug(
            "OFFLINE MODE / INSECURE MODE ACTIVE ALL Checks Have been Disabled ")
        # Sets Server Ip To your Local Ip address
        server_ip = IPAddr

        start_server_thread = threading.Thread.start(
            target=startServerOFFLINE(server_ip))

        # Starts Server With Your private
        start_server_thread.start()

        # cleanly Exits out of online server
        if (exit(0)):
            start_server_thread.join()

            logging.warning("Python Quit Cleanly ")

    else:
        print("set server in Online / offline mode to continue")
        logging.fatal("set server in Online / offline mode to continue")


def startServerOFFLINE(server_ip):

    global server_port

    # creates server Socket grabs socket exeptions
    logging.info(server_ip)

    udpIP = str(decode.ip_to_uint32(server_ip))

    try:
        # Creates Udp Scoket with auto Ip Binding
        # TODO: Work on UDP Port To read from json
        server = socket.socket(
            socket.AF_INET, socket.SOCK_DGRAM, socket.SOCK_STREAM)

        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

        server.bind((udpIP, 8080))

        logging.debug(server)

        logging.info("Socket successfully created")

    except socket.error as error:
        logging.fatal("SOCKET FAILD WITh ERROR" + error)

    logging.info("Server Socket Connected")

    while True:
        cpu_useage = psutil.cpu_percent(interval=1)

        logging.debug("Server is Active Wating for Client Connetion")

        logging.debug(cpu_useage)

        data = server.recv(4096)
        server.listen()

        logging.info("Received" + data + " from the client")

        if(data == "connected"):
            server.send(("Hello client").encode('utf-8'))

        elif (data == "info"):
            server.send((cpu_useage))


def startServerOnline(server_ip):
    global server_port

    # creates server Socket grabs socket exeptions
    logging.info(server_ip)

    udpIP = str(decode.ip_to_uint32(server_ip))

    try:
        # Creates Tcp Scoket with auto Ip Binding
        # TODO: Work on UDP Port To read from json
        server = socket.socket(
            socket.AF_INET, socket.SOCK_DGRAM, socket.SOCK_STREAM)

        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

        server.bind((udpIP, 9090))

        logging.debug(server)

        logging.info("Socket successfully created")

    except socket.error as error:
        logging.fatal("SOCKET FAILD WITh ERROR" + error)

    logging.info("Server Socket Connected")

    while True:
        cpu_useage = psutil.cpu_percent(interval=1)

        logging.debug("Server is Active Wating for Client Connetion")
        logging.debug(cpu_useage)

        data = server.recv(4096)
        server.listen()

        logging.info("Received" + data + " from the client")

        if(data == "Hello server"):
            server.send(("Hello client").encode('utf-8'))

        elif (data == "info"):
            server.send(cpu_useage)
