x = int(input("Enter a first number: "))
y = int(input("Enter a second number: "))

if y == 0:
    print("The quotient cannot be calculated.")
else:
    q = x / y
    print("The quotient is " + str(q))