numbers = {i for i in range(1, 21)}
numbers.remove(1)

# i = 2, 3, 4, 5, 6.... 21
for i in range(2, 21):
    if i % 2 == 0 and i != 2:
        numbers.discard(i)
    if i % 3 == 0 and i != 3:
        numbers.discard(i)
    if i % 5 == 0 and i != 5:
        numbers.discard(i)

# for i in range(2, 21):
#     if i % 2 == 0 and i != 2 and i in numbers:
#         numbers.remove(i)
#     if i % 3 == 0 and i != 3 and i in numbers:
#         numbers.remove(i)
#     if i % 5 == 0 and i != 5 and i in numbers:
#         numbers.remove(i)

print(numbers)
print(len(numbers))