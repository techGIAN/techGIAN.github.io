source = input().split(' ')
x0 = int(source[0])
y0 = int(source[1])

# initialization
x, y = x0, y0
is_on = False
bat = 50

print(x0, y0)

cmd = input()

while cmd != 'Q':

    if cmd == 'C':
        bat = 100
    elif cmd == 'P' and bat > 0:
        is_on = not is_on
    else:
        arr = cmd.split(' ')
        dirn = arr[0]
        steps = 0 if not is_on else (1 if len(arr) == 1 else int(arr[1]))

        if dirn == 'F':
            y += min(steps, bat)
        elif dirn == 'B':
            y -= min(steps, bat)
        elif dirn == 'L':
            x -= min(steps, bat)
        else:
            x += min(steps, bat)

        bat -= min(steps, bat)

    if bat == 0:
        is_on = False

    print(x, y)

    cmd = input()

d = ((x - x0) ** 2 + (y - y0) ** 2) ** 0.5
print("%.2f" % d)
