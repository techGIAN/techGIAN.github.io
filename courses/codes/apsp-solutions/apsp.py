def floyd_warshall(W):
    n = len(W)

    D = [[float('inf')] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if W[i][j] > 0:
                D[i][j] = W[i][j]

    for i in range(n):
        D[i][i] = 0

    for k in range(n):
        for i in range(n):
            for j in range(n):
                D[i][j] = min(D[i][j], D[i][k] + D[k][j])

    return D


def q1(filename):
    lines = []

    with open(filename, 'r') as file:
        for line in file:
            lines.append(line.strip().split())

    n = len(lines[0])
    weights = [[0] * n for _ in range(n)]

    for i, line in enumerate(lines):
        for j, val in enumerate(line):
            weights[i][j] = float(val)

    dist = floyd_warshall(weights)

    for row in dist:
        integers = [int(x) for x in row]
        print(integers)



q1('inputQ1.txt')



