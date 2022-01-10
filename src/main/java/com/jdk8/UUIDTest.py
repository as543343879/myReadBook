import uuid

try:
    mac = uuid.UUID(int=uuid.getnode()).hex[-12:]
    mac_address = ':'.join([mac[e:e + 2] for e in range(0, 11, 2)])
except:
    mac_address = ''
print(mac_address)
