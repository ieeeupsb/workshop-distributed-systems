import socket
import struct
from sys import argv
from sys import exit

if len(argv) < 3:
    print("Need an IP and a port number, in that order.")
    exit(-1)

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

sock.bind(("", int(argv[2])))

mreq = struct.pack("4sl", socket.inet_aton(argv[1]), socket.INADDR_ANY)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)

while True:
  print(sock.recv(10240))