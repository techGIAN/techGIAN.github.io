import math

G = 6.6743 * math.pow(10, -11)
m1 = 5.972 * math.pow(10, 24)
r = 6.371 * math.pow(10, 6)

m2 = float(input("Enter your mass (kg): "))

num = G * m1 * m2
denom = r ** 2
F = num / denom

print("The force of gravitation is (N): " + str(F))