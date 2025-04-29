# MODIFY THIS!
def floyd_warshall(W):
    n = len(W)

    D = [[float('inf')] * n for _ in range(n)]

    # TO-DO
    # Complete the Floyd-Warshall Algorithm

    return D


# DO NOT MODIFY!
# NO NEED TO CHANGE ANYTHING FOR Q1 OTHER THAN IMPLEMENTING FLOYD-WARSHALL ALGORITHM
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


def q2(filename):
    # DO NOT MODIFY
    # THIS PART OF THE CODE READS THE INPUT Q2 FILE
    with open(filename, 'r') as file:
        N = int(file.readline())
        M = int(file.readline())

        W = [[0] * N for _ in range(N)]

        for line in file:
            arr = line.split()
            s = int(arr[0]) - 1
            t = int(arr[1]) - 1
            timeST = float(arr[2])
            timeTS = float(arr[3])
            W[s][t] = timeST
            W[t][s] = timeTS

       # TO-DO
       # COMPLETE THIS METHOD FOR Q2


# comment/uncomment as needed
# q1('inputQ1.txt');
# q2('inputQ2.txt');


