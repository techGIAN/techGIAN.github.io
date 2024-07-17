open_time = int(input("What time does the restaurant open? "))
close_time = int(input("What time does the restaurant close? "))

print()
print("It's already %d:00, we are now open for business!" % open_time)
print()

for i in range(open_time*4, close_time*4):

    guest_num = i - open_time*4 + 1

    print("Guest #%d, Welcome to Alix's Restaurant!" % guest_num)
    combo = int(input("Please select your desired combo meal (1, 2, 3, 4): "))

    has_ordered = False
    while not has_ordered:
        match(combo):
            case 1:
                price = 8.23
                has_ordered = True
            case 2:
                price = 7.97
                has_ordered = True
            case 3:
                price = 7.05
                has_ordered = True
            case 4:
                price = 6.71
                has_ordered = True
            case _:
                print("I'm sorry, that is not in our menu.")
                combo = int(input("Please select your desired combo meal (1, 2, 3, 4): "))
                has_ordered = False

    cash = float(input("That will be $%.2f please. How much would you pay: " % price))
    while price > cash:
        print("The amount is not enough. Please try again.")
        cash = float(input("That will be $%.2f please. How much would you pay: " % price))

    change = cash - price

    if change == 0:
        print("Thank you for paying the exact amount. Please come again.")
    else:
        print("Thank you; $%.2f is your change. Please come again." % change)

    print()