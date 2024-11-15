C = int(input())        # capacity threshold
N = int(input())        # number of balls expected to juggle
weights = []            # weights of all the balls
curr_balls = []         # current balls that Charlie juggles
balls = 0               # number of balls that can be juggled

for i in range(N):      # get user inputs for the weight of balls
    weights.append(int(input()))

for w in weights:       # for each ball that has weight w

    if w > C:
        break

    curr_balls.append(w)
    balls += 1

    if len(curr_balls) > 4:
        curr_balls.pop(0)

    if sum(curr_balls) > C:
        balls -= 1
        break

print(balls)