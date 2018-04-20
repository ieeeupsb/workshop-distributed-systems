import threading

counter = 0

def add1(lock):
    global counter
    while True:
        lock.acquire()
        counter += 1
        lock.release()

lock = threading.Lock()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()
threading.Thread(target=add1, args=(lock,)).start()

while True:
    print(counter)