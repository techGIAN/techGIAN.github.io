age = int(input("Please enter your age: "))
# price = 8.95
price = 8.00

# if age >= 65:
#     price *= (1 - 0.2)

# if age <= 12:
#     price *= (1 - 0.1)
#
# print("The cost of the movie ticket is $%.2f" % price)
#
# if age > 12:
#     print("Sorry, you do not qualify for the discount.")

if age <= 12:
    price *= (1 - 0.1)
    print("The cost of the movie ticket is $%.2f" % price)
else:
    print("The cost of the movie ticket is $%.2f" % price)
    print("Sorry, you do not qualify for the discount.")