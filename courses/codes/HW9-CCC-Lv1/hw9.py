def recipe_completed(N):
    mountain_top = []
    branch = []
    for j in range(N):
        mountain_top.append(int(input()))

    n = 1
    while n < N:    # only need to verify cars #1, 2, ... N-1
        if len(mountain_top) > 0 and mountain_top[-1] == n:
            del mountain_top[-1]
            n += 1
        elif len(branch) > 0 and branch[-1] == n:
            del branch[-1]
            n += 1
        elif len(mountain_top) > 0:
            branch.append(mountain_top[-1])
            del mountain_top[-1]
        else:
            return False
    return True


T = int(input())
for i in range(T):
    N = int(input())
    print("Y" if recipe_completed(N) else "N")


