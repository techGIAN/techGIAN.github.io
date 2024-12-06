from collections import Counter

N = int(input())
names = [input() for i in range(N)]
for item in Counter(names).most_common():
    print(*item, sep=", ")
