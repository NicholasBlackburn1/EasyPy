import sys
import socket
import struct
from psutil._compat import long


def ip_to_uint32(ip):
    t = socket.inet_aton(ip)

    return struct.unpack("!I", t)[0]


def uint32_to_ip(ipn):
    t = struct.pack("!I", ipn)
    return socket.inet_ntoa(t)
