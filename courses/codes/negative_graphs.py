
# DO NOT MODIFY!
# reads a file path of weights, then returns a dict with keys as 2-tuple (edge) and values as weights of edge
def read_weights_from_file(path):
    weights = dict()
    with open(path, 'r') as f:
        for line in f:
            e_from, e_to, w = line.strip().split(' ')
            weights[(e_from, e_to)] = float(w)
    return weights

# DO NOT MODIFY!
# given a dict of edge to edge weights, return a list of nodes
def get_node_list(weights):
    edges = list(weights.keys())
    nodes = set()
    for e1, e2 in edges:
        nodes.add(e1)
        nodes.add(e2)
    return list(nodes)

# DO NOT MODIFY!
def pretty_print_dict(d):
    nodes = list(d)
    nodes.sort()
    print('{')
    for k in nodes:
        print(f'\t{k}\t:\t{d[k]}')
    print('}')

# Modify as needed
# It should return a dict of keys as edges 2-tuple and values as weights
def create_graph(weightsFile):
    W = dict()

    # either do this
    W[('S', 'A')] = 3
    W[('A', 'B')] = 5
    W[('S', 'B')] = 14

    # or do this when you have weightsFile
    W = read_weights_from_file(weightsFile)

    return W

# implement this code!
# Given a src node, find the path with the cheapest distance from src to each node in the graph
# return a dict of keys as nodes and values as path costs
def bellman_ford(weights, src):

    # initialization
    node_list = get_node_list(weights)
    dist = dict(zip(node_list, [float('inf')]*len(node_list)))
    dist[src] = 0

    # first round of relaxation: relax edges |N| - 1 times : to approximate distances
    for _ in range(len(node_list)-1):
        for e in list(weights.keys()):
            e_from, e_to = e
            dist[e_to] = min(dist[e_from] + weights[e], dist[e_to])

    # second round of relaxation: relax edges |N| - 1 times
    # to catch nodes in negative cycles or nodes reachable by negative cycles
    for _ in range(len(node_list) - 1):
        for e in list(weights.keys()):
            e_from, e_to = e
            if dist[e_from] + weights[e] < dist[e_to]:
                dist[e_to] = -float('inf')

    return dist


# def q2():
#     N = int(input())        # unused
#     M = int(input())
#     time_factors = dict()
#     for _ in range(M):
#         arr = map(int, input().split(' '))
#         time_factors[(arr[0], arr[1])] = arr[2]
#     sd = map(int, input().split(' '))
#     s, d = sd[0], sd[1]
#
#     dist = bellman_ford(time_factors, s)
#     print(dist[d])

def q2(filename):
    time_factors = dict()
    with open(filename, 'r') as f:
        i = 0
        for line in f:
            if i == 0:
                N = int(line.strip())       # unused
                i += 1
                continue
            elif i == 1:
                M = int(line.strip())
                i += 1
                continue
            elif i == M+2:
                sd = list(map(int, line.strip().split(' ')))
                s, d = sd[0], sd[1]
                dist = bellman_ford(time_factors, s)
                print(dist[d])
                return
            else:
                arr = list(map(int, line.strip().split(' ')))
                time_factors[(arr[0], arr[1])] = arr[2]
                i += 1


filename = 'inputTextQ2.txt'
q2(filename)