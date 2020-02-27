# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket
import logging
import helpers.IpDecode as decode

"""
IP Address Handler 
~~~~~~~~~~~~~~~~~~~

A Simple IP Address Handler written in Python, for human beings.
usage: 
>>> getClient() -> Gets Client Ip address  prints it out

>>> setServerIP() -> Sets Connection Ip  to Server Via Function
"""

# Logging for Ips
logging.basicConfig(filename='Client.log', level=logging.DEBUG)

Server_UDP_IP = str(input("ipaddress\n"))
Server_UDP_PORT = int(input('PORT\n'))


# Gets Client Info (like IP and Public Ip )


def getClientIP():
    logging.info("Loaded Client IP")

    hostname = socket.gethostname()
    IPAddr = socket.gethostbyname(hostname)
    ip = requests.get('https://checkip.amazonaws.com').text.strip()

    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    logging.debug("Your publicIp" + ip)
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    logging.debug("Your Computer Name is:" + hostname)
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    logging.debug("Your Computer IP Address is:" + IPAddr)
    logging.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")


def ConntectServerIP():
    logging.warning("STARTING to Connect to  UDP Server")
    logging.info("ServerIP" + Server_UDP_IP)
    logging.info("ServerPORT" + Server_UDP_PORT)

    ip = decode.ip_to_uint32(Server_UDP_IP)

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:

        s.connect((ip, 9090))
        s.sendall("connected")

        data = s.recv(4096)
