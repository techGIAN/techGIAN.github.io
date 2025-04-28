def dfs(G, food_locs, C, dest_loc):
    V = dict(zip(list(G.keys()), [False] * len(G)))
    S = []

    # keep track of how many food have been collected
    # and also if the destination is reachable
    num_of_food_obtained = 0
    dest_reached = False

    node = (0,0)            # always start at (0,0)
    S.append(node)
    while len(S) > 0:
        node = S.pop(-1)
        if not V[node]:
            V[node] = True

            # keep track of how much food collected and if the destination has been reached
            if node in food_locs:
                num_of_food_obtained += 1
            if node == dest_loc:
                dest_reached = True

            for nbr in G[node]:
                if not V[nbr]:
                    S.append(nbr)

    return num_of_food_obtained >= C and dest_reached

# helper function only ("cross product")
# example input List: {(0,0), (1,1), (2,2)}
# example output List: {((0,0), (1,1)), ((0,0), (2,2)), ((1,1), (2,2))}
def get_pairs(L):
    pairs = []
    for l1 in L:
        for l2 in L:
            pairs.append((l1, l2))
    return pairs

C = int(input())    # amount of food required
m = int(input())    # rows
n = int(input())    # cols

food_loc = []
G = dict()
for i in range(m):
    line = input()
    for j in range(n):
        if line[j] != 'X':
            loc = (i, j)
            if loc not in G:
                G[loc] = []
            if line[j] == 'F':
                food_loc.append(loc)

nodes = list(G.keys())
for u, v in get_pairs(nodes):
    if u != v:
        if v[1] == u[1] and abs(v[0] - u[0]) == 1 or v[0] == u[0] and abs(v[1] - u[1]) == 1:
            G[u].append(v)
            G[v].append(u)

# remove duplicates in the adj list:
for node in G.keys():
    val = list(set(G[node]))
    G[node] = val

output = 'Y' if dfs(G, food_loc, C, (m-1, n-1)) else 'N'
print(output)