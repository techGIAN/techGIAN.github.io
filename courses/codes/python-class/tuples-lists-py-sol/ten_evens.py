ten_evens = (0, 2, 4, 6, 8, 10, 12, 14, 16, 18)

# for i in range(len(ten_evens)):
#     if i % 2 == 1:
#         print(ten_evens[i])

for i in range(1, len(ten_evens), 2):
    print(ten_evens[i])