import copy

# simplest UnionFind implementation with Arrays/Lists
class UnionFind:

    def __init__(self):
        self.R = dict()

    def make(self, x):
        if x not in self.R:
            self.R[x] = x

    def find(self, x):
        return self.R[x]

    def union(self, x, y):
        rx = self.find(x)
        ry = self.find(y)
        if rx != ry:
            R_copy = copy.deepcopy(self.R)
            for k, v in R_copy.items():
                if v == ry:
                    self.R[k] = rx


def ex1():

    line = input().split(" ")
    friends = []
    while len(line) > 1:
        friends.append((line[0], line[1]))
        line = input().split(" ")
    q0, q1 = friends.pop(-1)

    uf = UnionFind()
    for f0, f1 in friends:
        uf.make(f0)
        uf.make(f1)
        uf.union(f0, f1)

    print('yes') if uf.find(q0) == uf.find(q1) else print('no')

# return true if all values of the dictionary d are equal; false o.w.
def all_values_equal(d):
    values = list(d.values())
    val = values[0]
    for i in range(1, len(values)):
        if val != values[i]:
            return False
    return True




ex1()
