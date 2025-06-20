def sample_graph():
    return {
        (0, 1, 15),
        (1, 2, -8),
        (2, 0, -6),
        (1, 6, 12),
        (1, 3, 1),
        (2, 4, 5),
        (2, 7, -2),
        (3, 4, 6),
        (4, 5, 3),
        (5, 3, -10),
        (5, 6, 13),
        (5, 7, 16)
    }

def get_node_set(G):
    s = set()
    for edge in G:
        s.add(edge[0])
        s.add(edge[1])
    return s

def bf(G):
    N = get_node_set(G)
    src = 0
    d = dict(zip(N, [float('inf')]*len(N)))
    d[src] = 0

    for _ in range(len(N) - 1):
        for edge in G:
            frm, to, wt = edge[0], edge[1], edge[2]
            d[to] = min(d[to], d[frm] + wt)

    for _ in range(len(N) - 1):
        for edge in G:
            frm, to, wt = edge[0], edge[1], edge[2]
            if d[frm] + wt < d[to]:
                d[to] = -float('inf')

    return d

G = sample_graph()
print(bf(G))