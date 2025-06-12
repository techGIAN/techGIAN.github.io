import math
from Point import Point

CACHED_DISTANCES = dict()


def distance(p1: Point, p2: Point):
    line = (p1, p2) if p1 < p2 else (p2, p1)

    if line not in CACHED_DISTANCES:
        CACHED_DISTANCES[line] = math.sqrt((p1.x - p2.x) ** 2 + (p1.y - p2.y) ** 2)

    return CACHED_DISTANCES[line]


def read_points():
    input()  # consume empty line
    n = int(input())
    points = set()
    for j in range(n):
        coord = input().split()
        points.add(Point(float(coord[0]), float(coord[1])))
    return points


M = int(input())

for i in range(M):
    V = read_points()
    total = 0

    S = {V.pop()}
    while len(V) > 0:
        min_dist, min_node = min((distance(u, v), v) for u in S for v in V)
        V.remove(min_node)
        S.add(min_node)
        total += min_dist

    print("%.2f" % total)
