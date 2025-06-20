squares = dict()

for i in range(1, 11):
    squares[i] = i * i

for k, v in squares.items():
    print(str(k) + ', ' + str(v))

print(len(squares))

for i in range(11, 16):
    squares[i] = i * i

for k, v in squares.items():
    print(str(k) + ', ' + str(v))

print(len(squares))

# consider a list of primes:
primes = [2, 3, 5, 7, 11, 13]

for p in primes:
    squares.pop(p, None)

for k, v in squares.items():
    print(str(k) + ', ' + str(v))