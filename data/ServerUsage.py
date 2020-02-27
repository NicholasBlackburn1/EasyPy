import psutil
import threading as thread
from network.ServerIpHandler import logging as log

# Starts DataCollection Thread for cpu


def Start(cputhread):
    cputhread = thread.Thread.start(target=CpuStats())
    cputhread.start()

# Quits  and Cleans up Thread From cpu data Collection


def Quit(cputhread):
    if (exit(0)):
        cputhread.join()
        log.warning("cpu Thread exited Cleanly")


def CpuStats(cpu_use, cpu_freq, cpu_amount):
    while 1:
        cpu_use = psutil.cpu_percent(0)
        cpu_freq = psutil.cpu_freq(True)
        cpu_amount = psutil.cpu_count(True)

    return float(cpu_use), tuple(cpu_freq), int(cpu_amount)
