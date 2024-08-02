numbers = {i for i in range(41)}
evens = {i for i in range(41) if i % 2 == 0}
for x in evens:
    numbers.remove(x)
print(numbers)