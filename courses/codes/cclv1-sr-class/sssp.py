def dijkstra(A, W, s):
    dist = dict()
    dist[s] = 0
    for v in A.keys():
        dist[v] = float("inf")
    dist[s] = 0
    S = set()
    Q = list(A.keys())

    while len(Q) > 0:

        min_val = min([dist[node] for node in Q])
        u = [key for key, value in dist.items() if value == min_val and key in Q][0]

        Q.remove(u)
        S.add(u)

        for v in A[u]:
            if v in S:
                continue
            if dist[v] > dist[u] + W[(u, v)]:
                dist[v] = dist[u] + W[(u, v)]

    return dist


P = int(input())
G = dict()
W = dict()
nodes = set()
edges = set()
for _ in range(P):
    arr = input().split(" ")
    s, d, c = arr[0], arr[1], int(arr[2])
    nodes.add(s)
    nodes.add(d)
    edge = (s,d)
    edges.add(edge)
    W[edge] = c

for node in nodes:
    if node not in G:
        G[node] = []

for edge in edges:
    e1, e2 = edge
    G[e1].append(e2)


home, dest = input().split(" ")

sssp = dijkstra(G, W, home)
print(sssp[dest]) 