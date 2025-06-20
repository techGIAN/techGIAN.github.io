'''
    Creates the adjacency list/set representation of a sample graph
'''
def sample_graph():
    return {
        0: {1, 2},
        1: {1, 2},
        2: {0, 1, 3, 4},
        3: {2},
        4: {2}
    }

'''
    Returns the node set N given adj list G
'''
def get_node_set(G):
    return set(G.keys())

'''
    Returns the edge set E given adj list G
'''
def get_edge_set(G, directed=False):
    edges = set()
    for k, v in G:
        for node in v:
            if directed or k < node:
                edges.add((k, node))
    return edges

'''
    Apply the BFS Algorithm on graph G
'''
def bfs(G):
    Q = []                          # initialize queue as list
    N = get_node_set(G)             # initialize nodes
    V = [False] * len(N)            # initialize boolean array; must be boolean dict/map for arbitrary nodes
    B = [float('inf')] * len(N)     # initialize inf breadth levels

    node = 0                        # let zero be the starting node
    Q.append(node)                  # enqueue source node
    V[node] = True                  # mark source node as visited
    B[node] = 0                     # source node has breadth 0

    while len(Q) > 0:

        node = Q.pop(0)                         # dequeue from Q
        print('Level {%d}: {%d}' % (B[node], node))        # print out the node

        for nbr in G[node]:                     # For each neighbor node
            if not V[nbr]:                      # Do the following if not yet visited
                V[nbr] = True                   # mark as visited
                Q.append(nbr)                   # add that to the queue
                B[nbr] = B[node] + 1            # increment its breadth

'''
    Apply the DFS Algorithm on graph G
'''
def dfs(G):
    S = []                          # initialize stack as list
    N = get_node_set(G)             # initialize nodes
    V = [False] * len(N)            # initialize boolean array; must be boolean dict/map for arbitrary nodes

    node = 0                        # let zero be the starting node
    S.append(node)                  # push the initial source node to the stack

    while len(S) > 0:

        node = S.pop()              # pop from the last of the stack
        if not V[node]:
            V[node] = True                          # mark node visited
            print('Visited node {%d}' % node)       # print node
            for nbr in G[node]:                     # For each neighbor node do as folows:
                if not V[nbr]:
                    S.append(nbr)                   # if not yet visited, push to the stack




G = sample_graph()

print('BFS: ')
bfs(G)

print('DFS: ')
dfs(G)