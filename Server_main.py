import network.ServerIpHandler as Ip
import logging

"""
this File is The Server main Program file 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
This is where all the sub files are Called
"""
logging.basicConfig(filename="main.log", level=logging.DEBUG)

logging.info("setting Server Ip")
Ip.readConfig()

Ip.getServerIP()
