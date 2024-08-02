numbers = {i for i in range(41)}
evens = {i for i in range(41) if i % 2 == 0}
odds = numbers.difference(evens)
print(odds)