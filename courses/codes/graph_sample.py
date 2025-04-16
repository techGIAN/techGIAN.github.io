# This code provides an example of a graph
# and how you can implement it in code

'''
    Returns an edge list representation of Graph Example 1
    Each pair represents an edge
    Order matters if the graph is directed (from, to)
    Order doesn't matter if graph is undirected - avoid duplicates (a, b) by ensuring a < b
'''
def edge_list_ex1():
    return [
        ('A', 'B'),
        ('A', 'C'),
        ('B', 'C'),
        ('A', 'D')
    ]

'''
    Returns an edge set representation of Graph Example 1
    Caveat: cannot handle multi-graphs, but this is faster in code!
    Each pair represents an edge
    Order matters if the graph is directed (from, to)
    Order doesn't matter if graph is undirected - avoid duplicates (a, b) by ensuring a < b
'''
def edge_set_ex1():
    return {
        ('A', 'B'),
        ('A', 'C'),
        ('B', 'C'),
        ('A', 'D')
    }

'''
    Returns an adjacency list representation of Graph Example 1 as a dictionary
    Keys: nodes
    Values: neighbors of each node as a list
'''
def adj_list_ex1():
    return {
        'A': ['B', 'C', 'D'],
        'B': ['A', 'C'],
        'C': ['A', 'B'],
        'D': ['A']
    }

'''
    Returns an adjacency set representation of Graph Example 1 as a dictionary
    Keys: nodes
    Values: neighbors of each node as a set 
    Faster and more natural as lists have an ordering that is captured which is not necessary
    But this also means that lists can allow duplicates and sets do not, so multi-graphs are not possible
'''
def adj_set_ex1():
    return {
        'A': {'B', 'C', 'D'},
        'B': {'A', 'C'},
        'C': {'A', 'B'},
        'D': {'A'}
    }

'''
    Returns an adjacency matrix representation of Graph Example 1 as a dictionary
    1 if there is an edge, 0 for no edge
    Symmetric along the main diagonal if undirected; asymmetric if directed
    All entries in the main diagonal are zeros if there are no self-loops in the graph
    Advtange of this is that the nodes are generic, but you have to know the ordering yourself that it was 'A', 'B', ...
'''
def adj_matrix_ex1():
    return [
        [0, 1, 1, 1],
        [1, 0, 1, 0],
        [1, 1, 0, 0],
        [1, 0, 0, 0]
    ]


'''
    Returns an edge weight set representation of Graph Example 2
    Keys: edges as pairs
    Values: edge weights
'''
def edge_set_ex2():
    return {
        ('A', 'B'): 3,
        ('A', 'C'): 2,
        ('C', 'B'): 1,
        ('D', 'A'): 4
    }

'''
    Returns an adjacency nested representation of Graph Example 2
'''
def adj_weight_dict_ex2():
    return {
        'A': {'B': 3, 'C': 2},
        'B': {},
        'C': {'B': 1},
        'D': {'A': 4}
    }

'''
    Returns an adjacency matrix representation of Graph Example 2
    Each entry A_ij, where i is the from and j is the to
    Each A_ij represents the edge weight
'''
def adj_matrix_ex2():
    return [
        [0, 3, 2, 1],
        [0, 0, 0, 0],
        [0, 1, 0, 0],
        [4, 0, 0, 0]
    ]