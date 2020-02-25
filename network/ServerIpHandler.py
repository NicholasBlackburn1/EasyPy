# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket
import logging
import json
from io import StringIO


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
    global server_ip
    global server_port

    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    # Sets local ip adress for server
    IPAddr = s.getsockname()[0]
    s.close()

    hostname = socket.gethostname()

    ip = requests.get('https://checkip.amazonaws.com').text.strip()

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

        # Starts Server With Your Public ip
        startServer(server_ip, server_port)

    elif (offline == True):
        logging.info("User Set Server to Be OFFLINE Mode")

        logging.debug(
            "OFFLINE MODE / INSECURE MODE ACTIVE ALL Checks Have been Disabled ")
        # Sets Server Ip To your Local Ip address
        server_ip = IPAddr
        logging.info("Set Server Ip to " + server_ip)

        startServer(server_ip, server_port)

    else:
        print("set server in Online / offline mode to continue")
        logging.fatal("set server in Online / offline mode to continue")


def startServer(server_ip, server_port):
    print("server ip" + server_ip + "port\n" + server_port)

    # creates server Socket and
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_socket.bind((server_ip, server_port))
