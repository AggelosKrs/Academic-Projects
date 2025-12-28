import hashlib

sha1 = hashlib.sha1()
password_test = 'password'.encode('utf-8')
password_Aggelos = 'password'.encode('utf-8')

sha1.update(password_test)
print(sha1.hexdigest())

sha1.update(password_Aggelos)
print(sha1.hexdigest())
