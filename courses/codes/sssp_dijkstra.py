import heapq

'''
    Returns an edge weight set representation of a sample weighted and undirected graph
    Keys: edges as pairs
    Values: edge weights
'''
def sample_weighted_graph():
    return {
        (0, 1): 4,
        (0, 2): 8,
        (1, 4): 6,
        (2, 3): 2,
        (4, 3): 10
    }

def nbrs(G, x):
    nb = set()
    for pair in G:
        if pair[0] == x:
            nb.add(pair[1])
        if pair[1] == x:
            nb.add(pair[0])
    return nb

'''
    Apply Dijkstra's on an weighted undirected graph G on source node s
'''
def dijkstra(G, s):

    # get the node set N
    N = {n1 for n1, n2 in G.keys()}
    N = N.union({n2 for n1, n2 in G.keys()})

    # create a dictionary of the shortest distances from source node s
    d = dict(zip(N, [float('inf')]*len(N)))

    # initialize source node as having shortest distance 0
    d[s] = 0

    # S is the set of visited nodes; we also intiailize a priority queue Q
    S = set()
    Q = []
    heapq.heapify(Q)
    for n in N:
        heapq.heappush(Q, (d[n], n))

    # while the priority queue is non-empty
    while len(Q) > 0:
        smallest_dist, smallest_node = heapq.heappop(Q)
        S.add(smallest_node)

        nbs = nbrs(G, smallest_node).difference(S)
        for v in nbs:
            w1 = G.get((smallest_node, v), -1)
            w2 = G.get((v, smallest_node), -1)
            w = max(w1, w2)
            d[v] = min(d[v], d[smallest_node] + w)

    return d

G = sample_weighted_graph()
source = 0
print(dijkstra(G, source))