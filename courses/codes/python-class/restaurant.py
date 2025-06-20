# Exercise: Import this code into PyCharm.
# Then fill in the blanks with the correct code

# Ask the user for what time the restaurant opens and closes
# inputs have to be integers and military times such as 14 are accepted (represents 2:00)
open_time = int(input("What time does the restaurant open? "))
close_time = int(input("What time does the restaurant close? "))

print()
print("It's already %d:00, we are now open for business!" % open_time)
print()

# Assume that one guest every 15 mins
# Each hour has 4 15 mins, so that's 4 guests per hour
for i in range(open_time*4, __________):

    # guest number
    guest_num = i - open_time*4 + 1

    # Ask the user which among the four combo meals they want
    # Each one has a different price
    print("Guest #%d, Welcome to Alix's Restaurant!" % guest_num)
    combo = int(input("Please select your desired combo meal (1, 2, 3, 4): "))

    # If the user picks any other value than 1 - 4, then prompt the user over and over until a valid input was entered
    # How we do it:
    # 1. Set a boolean variable called has_ordered initially False
    # 2. Do a while loop (while the customer has not ordered). Inside a loop, if the combo picked is from 1-4:
    #       a) Assign the price for it
    #       b) Set your has_ordered to True
    #    Else:
    #       a) Print a message that says that the item is not from the menu.
    #       b) Ask the user to select again from 1 to 4.
    has_ordered = __________
    while __________:
        # set the price depending on the combo meal selected
        match(__________):
            case 1:
                price = __________
                has_ordered = True
            case 2:
                price = __________
                has_ordered = True
            case 3:
                price = __________
                has_ordered = True
            case 4:
                price = __________
                has_ordered = True
            case _:
                print("I'm sorry, that is not in our menu.")
                combo = int(input("Please select your desired combo meal (1, 2, 3, 4): "))
                has_ordered = False

    # Ask the user for cash tender
    # While the price of the meal is higher than the cash tender, print a message saying the amount of money
    # paid is not enough, and ask again for another cash.
    cash = float(input("That will be $%.2f please. How much would you pay: " % price))
    while __________:
        print("The amount is not enough. Please try again.")
        cash = float(input("That will be $%.2f please. How much would you pay: " % price))

    # cash is now enough to pay for the meal; compute the change
    change = __________

    # Use an if-else and print message if the user pays the exact amount
    # If not, display the change the user will get
    if __________:
        print("Thank you for paying the exact amount. Please come again.")
    else:
        print("Thank you; $%.2f is your change. Please come again." % change)

    print()