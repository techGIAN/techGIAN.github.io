s = set()
num = int(input())
while num >= 0:
    s.add(num)
    num = int(input())
print('Entered numbers: ', end='')

evens = set()
odds = set()
for num in s:
    print(num, end=' ')
    if num % 2 == 0:
        evens.add(num)
    else:
        odds.add(num)

print('\nSum of even numbers: %d' % (sum(evens)))
print('Odd number count: %d' % (len(odds)))
