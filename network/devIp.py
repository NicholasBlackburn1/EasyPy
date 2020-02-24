# Grabs Local ip for dev info
# graps Public Ip for ip

import requests
import socket

hostname = socket.gethostname()
IPAddr = socket.gethostbyname(hostname)
ip = requests.get('https://checkip.amazonaws.com').text.strip()

print("Your public Ip" + ip)
print("Your Computer Name is:" + hostname)
print("Your Computer IP Address is:" + IPAddr)
