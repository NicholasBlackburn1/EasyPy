# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket


"""
IP Address Handler 
~~~~~~~~~~~~~~~~~~~

A Simple IP Address Handler written in Python, for human beings.
usage: 
>>> getClient() -> Gets Client Ip address  prints it out

>>> setServerIP() -> Sets Connection Ip  to Server Via Function
"""
UDP_IP = input("ip")


def getClientIP():
    hostname = socket.gethostname()

    IPAddr = socket.gethostbyname(hostname)

    ip = requests.get('https://checkip.amazonaws.com').text.strip()

    print("Your public Ip" + ip)
    print("Your Computer Name is:" + hostname)
    print("Your Computer IP Address is:" + IPAddr)


def setServerIP():
    global UDP_IP


def createServerCon():
    print(UDP_IP)
