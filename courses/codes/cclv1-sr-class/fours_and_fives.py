N = int(input())
ways = 0

for i in range(N // 5 + 1):
    if (N - 5*i) % 4 == 0:
        ways += 1

print(ways)
