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
>>> readConfig-> Gets Client Ip address  prints it out

>>> setServerIP() -> gets Ip to Server Via Function
"""

# Logging for Ips
logging.basicConfig(filename='Ip.log', level=logging.DEBUG)

# Booleans for Checking States
server_local = False
server_public = False

parstoml = [""]


def readConfig():
    global parstoml
    logging.info("config loading")

    # Loads ServerConfig
    Config = toml.loads("ServerConfig.Toml")

    # reads ServerConfig

    logging.info(Config)
    # logging.debug()


def getServerIP():
    global parstoml
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

    if (parstoml == [0]):
        logging.debug("User Set Server to Be Local ")

    if (parstoml == [1]):
        logging.debug("User Set Server to Be Public")

    else:
        print("set server in Online / offline mode to continue")
        logging.fatal("set server in Online / offline mode to continue")


def startServer(args):
    print("")
