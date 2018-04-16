import socket
from sys import argv
from sys import exit

if len(argv) < 3:
    print("Need an IP and a port, in that order")
    exit(-1)

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, 1)
sock.sendto("testing".encode('utf-8'), (argv[1], int(argv[2])))