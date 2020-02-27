import network.IpHandler as Ip
import logging

"""
this File is The Client main Program file 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
This is where all the sub files are Called
"""
logging.basicConfig(filename="main.log", level=logging.DEBUG)

logging.info("Getting Client Ip")
Ip.getClientIP()

logging.info("setting Server Ip")
Ip.ConntectServerIP()
