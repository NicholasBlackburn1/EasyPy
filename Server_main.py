import network.ServerIpHandler as Ip
import logging
import threading

"""
this File is The Server main Program file 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
This is where all the sub files are Called
"""


Ip.readConfig()

Ip.getServerIP()
