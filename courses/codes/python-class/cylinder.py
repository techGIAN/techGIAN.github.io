import math

# gets user input for the radius and height
r = float(input("Enter the radius: "))
h = float(input("Enter the height: "))

# computes the volume of the cylinder with radius r and height h
# alternative way for computing V = math.pi * r ** 2 * h
V = math.pi * r * r * h

# display the volume of the cylinder
print("The volume is %.3f" % V)