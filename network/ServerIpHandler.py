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

# reads Loaded Json

io = StringIO()
read = []


def readConfig():
    global read

    logging.info("config loading")

    # reads ServerConfig
    with open("ServerConfig.json", "r") as read_it:
        data = json.load(read_it)

    # Grabs mode from json
    read = data['mode']

    logging.info("\n" + read)


def getServerIP():

    global server_local
    global server_public

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

    if ():
        logging.debug("User Set Server to Be Local ")

    if ():
        logging.debug("User Set Server to Be Public")

    else:
        print("set server in Online / offline mode to continue")
        logging.fatal("set server in Online / offline mode to continue")


def startServer(args):
    print("")
