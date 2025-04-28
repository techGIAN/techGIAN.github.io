import sys

def traversal(cur, prev):
    if len(graph[cur]) == 1:
        order.append(cur)
    for adj in graph[cur]:
        if adj == prev:
            continue
        traversal(adj, cur)

# Fast input reading
input = sys.stdin.read
data = input().split()

n = int(data[0])
graph = [[] for _ in range(n + 1)]

index = 1
for _ in range(n - 1):
    a, b = int(data[index]), int(data[index + 1])
    graph[a].append(b)
    graph[b].append(a)
    index += 2

order = []
traversal(1, -1)
cnt = len(order)
print((cnt + 1) // 2)  # Number of pairs

if cnt % 2 == 1:  # Odd case, pair with any other leaf
    print(order[0], order[cnt - 1])
    cnt -= 1
    order.pop()

offset = cnt // 2  # Match first half with second half
for i in range(cnt // 2):
    print(order[i], order[i + offset])