small_primes = dict()

small_primes[1] = 2
small_primes[2] = 3
small_primes[3] = 5
small_primes[4] = 7
small_primes[5] = 11
small_primes[6] = 13
small_primes[7] = 17
small_primes[8] = 19
small_primes[9] = 23
small_primes[10] = 29

for k, v in small_primes.items():
    print(str(k) + ', ' + str(v))

print(len(small_primes))
