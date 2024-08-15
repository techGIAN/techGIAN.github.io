def row(n):
    r = [1]
    if n > 1:
        w = row(n - 1)
        for i in range(n - 2):
            r.append(w[i] + w[i + 1])
        r.append(1)
    return r


def pascal(n):
    for i in range(1, n + 1):
        arr = row(i)
        for j in range(i):
            print(arr[j], '\t', end='')
        print()


pascal(10)