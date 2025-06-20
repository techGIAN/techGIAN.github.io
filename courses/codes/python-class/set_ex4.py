hundred_evens = frozenset(i for i in range(101) if i % 2 == 0)
hundred_odds = frozenset(i for i in range(101) if i % 2 == 1)
numbers = set()

for x in hundred_evens:
    numbers.add(x)
for x in hundred_odds:
    numbers.add(x)

for x in numbers:
    print(x)
