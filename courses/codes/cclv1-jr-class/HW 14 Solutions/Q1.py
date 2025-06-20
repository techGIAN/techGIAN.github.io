def build_tree(m):
    """
    Builds a tree
    :param m: number of edges
    :return: tree
    """
    t = dict()
    for i in range(m):
        a, b = (int(x) for x in input().split())
        if a in t:
            t[a].add(b)
        else:
            t[a] = {b}
    return t


def search_tree(t, p, q):
    """
    BFS the tree t, starting from value p, for value q.
    :param n: nodes are from 1 to n
    :param t: the tree
    :param p: source value
    :param q: target value
    :return: True if q is reachable from p.  False if it is not.
    """
    discovered = set()
    queue = [p]
    while len(queue) > 0:
        u = queue.pop(0)
        if u == q:
            return True
        if u in t:
            for v in t[u]:
                if v not in discovered:
                    discovered.add(v)
                    queue.append(v)
    return False


N, M = (int(x) for x in input().split())
my_tree = build_tree(M)
P, Q = (int(x) for x in input().split())
if search_tree(my_tree, P, Q):
    print("yes")
elif search_tree(my_tree, Q, P):
    print("no")
else:
    print("unknown")