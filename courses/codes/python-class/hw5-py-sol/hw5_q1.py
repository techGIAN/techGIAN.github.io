# ==========================================================
# TUPLE
# ==========================================================

# # Q1a
# t = tuple()
# for _ in range(10):
#     num = int(input())
#     t += (num,)
#
# # Q1b
# print('Entered numbers: ', end='')
# for num in t:
#     print(num, end=' ')
#
# # Q1c
# print('\nReversed order: ', end='')
# for i in range(9, -1, -1):
#     print(t[i], end=' ')
#
# #Q1d
# odds = tuple()
# evens = tuple()
#
# for num in t:
#     if num % 2 == 0:
#         evens += (num,)
#     else:
#         odds += (num,)
#
# print('\nOdd numbers: ', end='')
# for num in odds:
#     print(num, end=' ')
#
# print('\nEven numbers: ', end='')
# for num in evens:
#     print(num, end=' ')
#
# #Q1e
# max_num = max(t)
# min_num = min(t)
# print('\nLargest number: ' + str(max_num))
# print('Smallest number: ' + str(min_num))
#
# #Q1f
# sum_num = sum(t)
# print('Sum of nums number: ' + str(sum_num))

# ==========================================================
# LIST
# ==========================================================

# Q1a
t = list()
for _ in range(10):
    num = int(input())
    t.append(num)

# Q1b
print('Entered numbers: ', end='')
for num in t:
    print(num, end=' ')

# Q1c
print('\nReversed order: ', end='')
for i in range(9, -1, -1):
    print(t[i], end=' ')

#Q1d
odds = list()
evens = list()

for num in t:
    if num % 2 == 0:
        evens.append(num)
    else:
        odds.append(num)

print('\nOdd numbers: ', end='')
for num in odds:
    print(num, end=' ')

print('\nEven numbers: ', end='')
for num in evens:
    print(num, end=' ')

#Q1e
max_num = max(t)
min_num = min(t)
print('\nLargest number: ' + str(max_num))
print('Smallest number: ' + str(min_num))

#Q1f
sum_num = sum(t)
print('Sum of nums number: ' + str(sum_num))