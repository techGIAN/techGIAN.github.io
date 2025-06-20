# ==========================================================
# TUPLE
# ==========================================================

# # Q2a
# t = tuple()
# num = int(input())
# while num >= 0:
#     t.append(num)
#     num = int(input())
#
# # Q2b
# print('Entered numbers: ', end='')
# for num in t:
#     print(num, end=' ')
#
# # Q2c
# print('\nReversed order: ', end='')
# for i in range(9, -1, -1):
#     print(t[i], end=' ')
#
# #Q2d
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
# #Q2e
# max_num = max(t)
# min_num = min(t)
# print('\nLargest number: ' + str(max_num))
# print('Smallest number: ' + str(min_num))
#
# #Q2f
# sum_num = sum(t)
# print('Sum of nums number: ' + str(sum_num))

# ==========================================================
# LIST
# ==========================================================

# Q2a
t = list()
num = int(input())
while num >= 0:
    t.append(num)
    num = int(input())

# Q2b
print('Entered numbers: ', end='')
for num in t:
    print(num, end=' ')

# Q2c
print('\nReversed order: ', end='')
for i in range(9, -1, -1):
    print(t[i], end=' ')

#Q2d
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

#Q2e
max_num = max(t)
min_num = min(t)
print('\nLargest number: ' + str(max_num))
print('Smallest number: ' + str(min_num))

#Q2f
sum_num = sum(t)
print('Sum of nums number: ' + str(sum_num))