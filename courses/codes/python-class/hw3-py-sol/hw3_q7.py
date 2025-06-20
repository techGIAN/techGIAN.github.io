n = int(input("Please enter integers:\n"))

count_odd = 0           # counts how many odd integers are inputted
sum_odd = 0             # sums the values of all odd integers

while n != 0:
    if n % 2 == 1:      # checks if integer is odd
        count_odd += 1  # counts the odd integers
        sum_odd += n    # adds the odd integer to the cumulative sum
    n = int(input())    # asks the integer at each iteration; only stop when n = 0

if count_odd == 0:
    print(0)
else:
    print(sum_odd / count_odd)

