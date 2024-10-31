def grow(s, k):
    if k == 0:
        return s
    r = []
    for i in s:
        r.append(i + "0")
        if i[-1] == '0':
            r.append(i + "1")

    return grow(r, k-1)


d = int(input())
zeroes = grow(["0"], d-1)
ones = grow(["1"], d-1)

for a in zeroes + ones:
    print(a)
