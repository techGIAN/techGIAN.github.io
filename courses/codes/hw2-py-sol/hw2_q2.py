x = int(input("Enter the first number: "))
y = int(input("Enter the second number: "))

z = x // y      # integer division
w = x / y       # regular division
r = x % y       # remainder

print("%d divided by %d is %.4f" % (x, y, w))
print("%d goes into %d ... %d times, with a remainder of %d" % (y, x, z, r))