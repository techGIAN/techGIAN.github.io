def bounce(k):
    if k <= 0:
        return str(k)
    else:
        return str(k) + " " + bounce(k - 5) + " " + str(k)


print(bounce(int(input())))