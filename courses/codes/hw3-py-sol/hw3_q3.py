hrs = int(input("Enter the number of hours worked: "))
parts = float(input("Enter the cost of the parts: "))

price = 100 * hrs + parts

if price < 150:
    price = 150

print("The total cost of the job is $%.2f" % price)