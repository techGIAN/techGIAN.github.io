year = int(input())
is_leap = False

if year % 400 == 0:
    is_leap = True
elif year % 100 == 0:
    is_leap = False
elif year % 4 == 0:
    is_leap = True
    
if is_leap:
    print(str(year) + " is a leap year.")
else:
    print(str(year) + " is not a leap year.")