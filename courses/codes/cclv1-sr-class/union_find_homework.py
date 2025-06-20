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



# return true if all values of the dictionary d are equal; false o.w.
def all_values_equal(d):
    values = list(d.values())
    val = values[0]
    for i in range(1, len(values)):
        if val != values[i]:
            return False
    return True

def ex2():
    N = int(input())
    m = int(input())

    log = []
    for _ in range(m):
        log.append(tuple(map(int, input().split())))

    log.sort(key=lambda x: x[2])

    uf = UnionFind()
    for x, y, t in log:
        uf.make(x)
        uf.make(y)
        uf.union(x, y)

        if all_values_equal(uf.R) and sorted(list(uf.R.keys())) == list(range(1, N+1)):
            print(t)
            return

    print('-1')


ex2()
