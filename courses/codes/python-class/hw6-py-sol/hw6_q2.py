def reverse(s):
    if s == '':
        return ''
    else:
        return s[-1] + reverse(s[0:-1])

print(reverse('Hello World'))
print(reverse('python is awesome'))
print(reverse('kayak'))