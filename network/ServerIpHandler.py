# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket
import logging
import toml


"""
Server IP Address Handler 
~~~~~~~~~~~~~~~~~~~

A Simple IP Address Handler written in Python, for human beings.
usage: 
>>> getClient() -> Gets Client Ip address  prints it out

>>> setServerIP() -> Sets Connection Ip  to Server Via Function
"""

# Logging for Ips
logging.basicConfig(filename='Ip.log', level=logging.DEBUG)

# Booleans for Checking States
server_local = False
server_public = False


def readConfig():
    logging.info("config loading")


def getServerIP(args):
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

    if (server_local):
        logging.debug("User Set Server to Be Local ")

    if (server_public):
        logging.debug("User Set Server to Be Public")

    else:
        print("set server in Online / offline mode to continue")
        logging.fatal("set server in Online / offline mode to continue")


def startServer(args):
    print("")
