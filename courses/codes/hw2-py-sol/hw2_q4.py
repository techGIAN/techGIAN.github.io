toonies = int(input("How many toonies do you have? "))
loonies = int(input("How many loonies do you have? "))
quarters = int(input("How many quarters do you have? "))
dimes = int(input("How many dimes do you have? "))
nickels = int(input("How many nickels do you have? "))

money = toonies * 2 + loonies + quarters * 0.25 + dimes * 0.10 + nickels * 0.05

print("The total value of your coins comes up to be $%.2f" % money)

