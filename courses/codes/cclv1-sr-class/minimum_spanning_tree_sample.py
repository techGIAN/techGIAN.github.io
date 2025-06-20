def sample_weighted_graph():
    return {
        (0, 1): 2,
        (0, 2): 8,
        (1, 4): 6,
        (2, 3): 2,
        (4, 3): 6
    }

def get_node_set(G):
    nodes = set()
    for edge in G:
        nodes.add(edge[0])
        nodes.add(edge[1])
    return nodes

def get_edge_set(G):
    return G.keys()

def get_neighbors(G, n):
    nbrs = set()
    for edge in G:
        if edge[0] == n or edge[1] == n:
            nbrs.add(edge[0])
            nbrs.add(edge[1])
    nbrs.discard(n)
    return nbrs

def prim(G):
    T = set()
    T_nodes = set()
    N = get_node_set(G)
    E = get_edge_set(G)
    V = [False] * len(N)
    s = 0
    T_nodes.add(s)
    V[s] = True

    while len(T) < len(N) - 1:
        candidate_edges = set()
        for node in T_nodes:
            nbrs = get_neighbors(G, node)
            for nbr in nbrs:
                if not V[nbr]:
                    min_node = min(node, nbr)
                    max_node = max(node, nbr)
                    candidate_edges.add((min_node, max_node))
        
        min_weight = float('inf')
        min_edge = None

        for edge in candidate_edges:
            e1 = (min(edge), max(edge))
            e2 = (max(edge), min(edge))
            if e1 in G:
                if G[e1] < min_weight:
                    min_weight = G[e1]
                    min_edge = e1
            else:
                if G[e2] < min_weight:
                    min_weight = G[e2]
                    min_edge = e2
        
        V[min_edge[0]] = True
        V[min_edge[1]] = True
        T.add(min_edge)
        T_nodes.add(min_edge[0])
        T_nodes.add(min_edge[1])

    return T

def kruskal(G):
    N = get_node_set(G)
    E = get_edge_set(G)
    E_sorted = {k: v for k, v in sorted(G.items(), key=lambda item: item[1])}
    DS = dict()         # implementing a disjoint set as a dictionary, with keys as the elements, values as the representative
    for node in N:
        DS[node] = node        # equivalent to make()
    T = set()
    
    for edge in E_sorted:
        n1, n2 = edge
        if DS[n1] != DS[n2]:            # equivalent to find()
            T.add(edge)
            for n in DS:                # this for loop is equivalent to union(); using a DS class is still much better
                if DS[n] == DS[n2]:
                    DS[n] = DS[n1]

    
    return T

G = sample_weighted_graph()
print('Prim Algorithm:')
print(prim(G))
print('Kruskal Algorithm:')
print(kruskal(G))