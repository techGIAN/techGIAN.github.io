# Prim's algorithm
# Input: graph G (adj list), weights dict (keys are edges, which are tuples; values are weights)
# Output: Set of edges that make up the MST
def prim(G, W):
    T_nodes, T_edges = set(), set()                             # the min spanning tree
    V = dict(zip(G.keys(), [False]*len(G.keys())))              # booleans for visited nodes

    s = list(G.keys())[0]                                       # source node (arbitrary chosen)
    T_nodes.add(s)                                              # add node to the MST
    V[s] = True                                                 # node has been visited

    while len(T_edges) < len(G) - 1:

        # obtain the connected nodes and connected edges (i.e., the candidate edges
        # that will be added to the MST)
        connected_nodes, connected_edges = set(), set()
        for node in T_nodes:
            nbrs = G[node]
            for nbr in nbrs:
                if not V[nbr]:
                    connected_nodes.add(nbr)

        for n1 in T_nodes:
            for n2 in connected_nodes:
                key = (n1, n2) if n1 < n2 else (n2, n1)
                if key in W:
                    connected_edges.add(key)

        # among the candidate edges, get the cheapest weight
        min_weight = float('inf')
        min_edge = None
        for edge in connected_edges:
            weight_key = (edge[0], edge[1]) if edge[0] < edge[1] else (edge[1], edge[0])
            if W[weight_key] < min_weight:
                min_weight = W[weight_key]
                min_edge = edge

        # add the cheapest weight to the MST
        # then identify the new nodes in the MST as visited
        e1, e2 = min_edge
        V[e1], V[e2] = True, True
        T_edges.add(min_edge)
        T_nodes = T_nodes.union({e1, e2})

    return T_nodes, T_edges

# Helper Functions Only =============================================

# ensures that (e1, e2) edges are e1 < e2
def ordered_pairs(W):
    new_W = dict()
    for k, v in W.items():
        if k[0] > k[1]:
            new_key = (k[1], k[0])
            new_W[new_key] = v
        else:
            new_W[k] = v
    return new_W

# return the graph adj list G given the weights dict
def get_graph_given_weights(W):
    G = dict()
    for w in W:
        if w[0] not in G:
            G[w[0]] = []
        G[w[0]].append(w[1])

        if w[1] not in G:
            G[w[1]] = []
        G[w[1]].append(w[0])
    return G




n = int(input())
W = dict()
for _ in range(n):
    arr = input().split(' ')
    W[(arr[0], arr[1])] = int(arr[2])

W = ordered_pairs(W)            # ensures that each edge (e1, e2) is e1 < e2 to avoid duplicates
G = get_graph_given_weights(W)
MST_Nodes, MST_Edges = prim(G, W)

for e in MST_Edges:
    print(e[0] + ' ' + e[1])