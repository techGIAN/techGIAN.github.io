import math

# a = 1
# b = 15
# c = 50
a = float(input("Enter a: "))
b = float(input("Enter b: "))
c = float(input("Enter c: "))

# D = math.pow(b, 2) - 4 * a * c
# D = b * b - 4 * a * c
D = b ** 2 - 4 * a * c

x1 = (-b + math.sqrt(D))/(2 * a)
x2 = (-b - math.sqrt(D))/(2 * a)

print("%.1f" % x1)
print("%.1f" % x2)