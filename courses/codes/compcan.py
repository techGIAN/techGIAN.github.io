'''
    Print Matrix M
    Change value ov to new value nv if the parameters are supplied
'''
def print_matrix(M, ov='', nv=''):
    if ov == '' and nv == '' or ov == nv:
        for i in range(len(M)):
            for j in range(len(M[0])):
                print(int(M[i][j]), end=' ')
            print()
    else:
        for i in range(len(M)):
            for j in range(len(M[0])):
                v = nv if M[i][j] == ov else M[i][j]
                print(int(v), end=' ')
            print()


'''
    Applies Floyd-Warshall Algorithm on the adj matrix of weights W
'''
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

N = int(input())
M = int(input())

W = [[0 for x in range(N)] for _ in range(N)]

for _ in range(M):
    f, t, w = tuple(map(int, input().split()))
    W[f - 1][t - 1] = w

D = floyd_warshall(W)
print_matrix(D, float('inf'), -1)
