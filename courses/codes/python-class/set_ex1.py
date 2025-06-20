# # Task 1
# small_primes = {29, 23, 19, 17, 13, 11, 7, 5, 3, 2}
# for prime in small_primes:
#     print(prime)

# Task 2
evens = set()
for i in range(10):
    evens.add(2*i)
print(evens)
print(len(evens))

for i in range(20, 30, 2):
    evens.add(i)
print(evens)
print(len(evens))