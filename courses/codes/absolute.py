x = int(input("Enter an integer: "))

# if x >= 0:
#     absolute_x = x
# else:
#     absolute_x = -x

absolute_x = x if x >= 0 else -x

print(absolute_x)