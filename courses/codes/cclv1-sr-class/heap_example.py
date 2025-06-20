def add(x):
    global H
    H.append(x)
    idx = len(H) - 1
    upheap(idx)

def peek():
    global H
    return H[0]

def extract_min():
    global H
    min_value = peek()
    H = [H[-1]] + H[1:-1]
    downheap(0)
    return min_value


def upheap(i):
    global H
    p = (i - 1) // 2
    if p == -1:
        return
    if H[p] > H[i]:
        H[p], H[i] = H[i], H[p]
        upheap(p)

def downheap(i):
    global H
    lc = 2*i + 1
    rc = 2*i + 2

    if lc >= len(H):
        return
    elif rc >= len(H):
        H[i], H[lc] = H[lc], H[i]
    else:
        if H[lc] <= H[rc]:
            H[i], H[lc] = H[lc], H[i]
            downheap(lc)
        else:
            H[i], H[rc] = H[rc], H[i]
            downheap(rc)


H = []

add(6)
print(f"Min element: {peek()}; H = {H}")

add(50)
print(f"Min element: {peek()}; H = {H}")

add(11)
print(f"Min element: {peek()}; H = {H}")

add(25)
print(f"Min element: {peek()}; H = {H}")

add(42)
print(f"Min element: {peek()}; H = {H}")

add(20)
print(f"Min element: {peek()}; H = {H}")

add(98)
print(f"Min element: {peek()}; H = {H}")

add(76)
print(f"Min element: {peek()}; H = {H}")

add(19)
print(f"Min element: {peek()}; H = {H}")

add(55)
print(f"Min element: {peek()}; H = {H}")

add(88)
print(f"Min element: {peek()}; H = {H}")

add(2)
print(f"Min element: {peek()}; H = {H}")

print(H)

extract_min()
print(f"Min element: {peek()}; H = {H}")

extract_min()
print(f"Min element: {peek()}; H = {H}")

extract_min()
print(f"Min element: {peek()}; H = {H}")