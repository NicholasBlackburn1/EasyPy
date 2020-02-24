# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket
import logging


"""
IP Address Handler 
~~~~~~~~~~~~~~~~~~~

A Simple IP Address Handler written in Python, for human beings.
usage: 
>>> getClient() -> Gets Client Ip address  prints it out

>>> setServerIP() -> Sets Connection Ip  to Server Via Function
"""

# Logging for Ips
logging.basicConfig(filename='Ip.log', level=logging.DEBUG)

Server_UDP_IP = input("ipaddress\n")
Server_UDP_PORT = input('PORT\n')

logging.info("ServerIP" + Server_UDP_IP)
logging.info("ServerPORT" + Server_UDP_PORT)

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


def getServerIP(Server_UDP_IP):
    print("not")


def setServerIP():

    print("UDP target IP:", Server_UDP_IP)
    print("UDP target port:", Server_UDP_PORT)
