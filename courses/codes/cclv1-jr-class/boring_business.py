well_plan = [[False for y in range(200)] for x in range(401)]


def drill(x, y, direction, steps):
    is_danger = False
    for i in range(steps):
        if direction == 'd':
            y -= 1
        elif direction == 'u':
            y += 1
        elif direction == 'l':
            x -= 1
        elif direction == 'r':
            x += 1
        else:
            print("Invalid direction")

        if well_plan[x][y]:
            is_danger = True
        else:
            well_plan[x][y] = True

    return x, y, is_danger


def print_well_plan(span_x, span_y):
    for j in range(-1, -span_y-1, -1):
        for i in range(-span_x-1, span_x+1):
            print('X' if well_plan[i][j] else ' ', end='')
        print()


# initial setup
current_x = 0
current_y = -1
current_danger = False
well_plan[current_x][current_y] = True

current_x, current_y, current_danger = drill(current_x, current_y, 'd', 2)
current_x, current_y, current_danger = drill(current_x, current_y, 'r', 3)
current_x, current_y, current_danger = drill(current_x, current_y, 'd', 2)
current_x, current_y, current_danger = drill(current_x, current_y, 'r', 2)
current_x, current_y, current_danger = drill(current_x, current_y, 'u', 2)
current_x, current_y, current_danger = drill(current_x, current_y, 'r', 2)
current_x, current_y, current_danger = drill(current_x, current_y, 'd', 4)
current_x, current_y, current_danger = drill(current_x, current_y, 'l', 8)
current_x, current_y, current_danger = drill(current_x, current_y, 'u', 2)

# print_well_plan(10, 10)
while True:
    cmd = input().split()
    if cmd[0] == 'q':
        break
    else:
        current_x, current_y, current_danger = drill(current_x, current_y, cmd[0], int(cmd[1]))
        # print_well_plan(10, 10)
        print(current_x, current_y, "DANGER" if current_danger else "safe")
        if current_danger:
            break