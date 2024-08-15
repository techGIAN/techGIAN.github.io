primes = set(range(1,101))

# remove all multiples of 2, 3, 5, 7 greater than themselves
for i in range(4, 101, 2):
    primes.discard(i)

for i in range(6, 101, 3):
    primes.discard(i)

for i in range(10, 101, 5):
    primes.discard(i)

for i in range(14, 101, 7):
    primes.discard(i)

primes.discard(1)       # remove 1 as it is not prime

num = int(input())

s = set()
while num != -1:
    s.add(num)
    num = int(input())

# s = s.difference(primes)
s.difference_update(primes)     # same thing

print('Non-primes: ', end='')
for num in s:
    print(num, end=' ')