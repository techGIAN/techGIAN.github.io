# Q1 Solution ==============================================
def merge_sort(A, p, r):
    if p < r:
        q = (p + r) // 2
        merge_sort(A, p, q)
        merge_sort(A, q+1, r)
        merge(A, p, q, r)

# merge subarrays A[p..q] and A[q+1..r]
def merge(A, p, q, r):
    AL = A[p:q+1]
    AR = A[q+1:r+1]
    cl = cr = 0
    k = p
    while cl < q-p+1 and cr < r-q:
        if AL[cl] <= AR[cr]:
            A[k] = AL[cl]
            cl += 1
        else:
            A[k] = AR[cr]
            cr += 1
        k += 1

    while cl < q-p+1:
        A[k] = AL[cl]
        cl += 1
        k += 1

    while cr < r-q:
        A[k] = AR[cr]
        cr += 1
        k += 1

def q1():
    A = [25, 38, 97, 41, 69, 46, 70, 31]
    merge_sort(A, 0, len(A)-1)
    print(A)

# Q2 Solution ==============================================
def gen_midstring(start, mid, end, k):
    if k == 1:
        return start + mid + end
    else:
        middle_string = gen_midstring(start, mid, end, k-1)
        middle_string = mid + middle_string[1:len(middle_string)-1]
        return start + middle_string + end

def reverse_string(s):
    if len(s) == 1:
        return s
    else:
        return s[-1] + reverse_string(s[0:-1])

def reverse_words(s):
    if ' ' not in s:
        return s
    else:
        arr = s.split(' ')
        new_s = ' '.join(arr[0:-1])
        return arr[-1] + ' ' + reverse_words(new_s)

def q2a():
    start, mid, end, k = 'c', 'a', 'r', 4
    print(gen_midstring(start, mid, end, k))

def q2b():
    s = "Hello World"
    print(reverse_string(s))

def q2c():
    s = 'The dog is barking'
    print(reverse_words(s))

# Q3 Solution ==============================================
def is_palindrome(A):
    if len(A) == 1:
        return True
    if len(A) == 2:
        return A[0] == A[1]
    else:
        return A[0] == A[len(A)-1] and is_palindrome(A[1:len(A)-1])

def q3():
    A = [88, 88, 34, 56, 11, 56, 34, 87]
    max_len = 0
    for i in range(len(A)):
        for j in range(i+1, len(A)):
            if is_palindrome(A[i:j]):
                max_len = max(max_len, j-i)

    print(max_len)

# Q4 Solution ==============================================
def decode(tree, i, code):
    if code == '0':
        return tree[2*i + 1]
    elif code == '1':
        return tree[2*i + 2]
    else:
        if code[0] == '0':
            return decode(tree, 2*i + 1, code[1:])
        else:
            return decode(tree, 2*i + 2, code[1:])

def q4():
    T = [None, None, None, None, None, None, None, None, None, None,
         'O', 'M', 'I', 'R', 'G', 'C', 'L', 'P', 'A', 'N', 'S',
         None, None, None, None, None, None, None, None, None, None]
    code = '0010'
    i = 0   # start exploration at node rooted at 0
    print(decode(T, i, code))


# Q5 Solution ==============================================
def rec_max_num(L):
    if len(L) == 1:
        return L[0]

    mid = len(L) // 2
    subL1 = rec_max_num(L[0:mid])
    subL2 = rec_max_num(L[mid+1:])

    if subL1 > subL2:
        return subL1
    else:
        return subL2

def q5():
    L = [58, 34, 100, 62, 77, 19, 83]
    print(rec_max_num(L))



# Q6 Solution ==============================================
def find_paths(grid, m, n, path=[], i=0, j=0, paths=[]):
    # Base case: If current cell is the bottom-right cell, add the current path to the paths list
    if i == m - 1 and j == n - 1:
        paths.append(path + [(i, j)])
        return

    # Recursive case: Try moving right
    if j < n - 1 and (i, j + 1) not in path:
        find_paths(grid, m, n, path + [(i, j)], i, j + 1, paths)

    # Recursive case: Try moving down
    if i < m - 1 and (i + 1, j) not in path:
        find_paths(grid, m, n, path + [(i, j)], i + 1, j, paths)

    # Recursive case: Try moving left
    if j > 0 and (i, j - 1) not in path:
        find_paths(grid, m, n, path + [(i, j)], i, j - 1, paths)

    # Recursive case: Try moving up
    if i > 0 and (i - 1, j) not in path:
        find_paths(grid, m, n, path + [(i, j)], i - 1, j, paths)

    return paths

def compute_score(G, path):
    score = 0
    for p in path:
        score += G[p[0]][p[1]]
    return score

def q6():
    G = [
        [0, 7, 1, 3],
        [4, 5, 8, 0],
        [9, 3, -6, 0]
    ]
    paths = find_paths(G, len(G), len(G[0]))
    scores = []
    for path in paths:
        s = compute_score(G, path)
        scores.append(s)
    print(max(scores))


# Q7 Solution ==============================================
def flatten_list(nested_list):
    flattened = []
    for item in nested_list:
        if isinstance(item, list):
            flattened.extend(flatten_list(item))
        else:
            flattened.append(item)
    return flattened

def q7():
    L = [[1,2], 3]
    print(flatten_list(L))



# Q8 Solution ==============================================
def infection_spread(A, seeds, infected_dict=None):
    if infected_dict is None:
        infected_dict = dict(zip(A.keys(), [False]*len(A.keys())))

    if not seeds:           # no more seeds to process
        return infected_dict

    seed = seeds.pop(0)
    infected_dict[seed] = True

    for friend in A[seed]:
        if not infected_dict[friend]:
            seeds.append(friend)

    return infection_spread(A, seeds, infected_dict)

def q8():
    adj_list = {
        'A': ['B', 'C', 'D', 'E'],
        'B': ['A', 'C', 'D', 'E'],
        'C': ['A', 'B', 'D', 'E'],
        'D': ['A', 'B', 'C', 'E'],
        'E': ['A', 'B', 'C', 'D'],
        'F': ['G'],
        'G': ['F'],
        'H': []
    }
    seeds = ['A']
    infected_dict = infection_spread(adj_list, seeds)

    print(infected_dict)


# Main Method ==============================================
def main():
    # q1()
    # q2a()
    # q2b()
    # q2c()
    # q3()
    # q4()
    # q5()
    # q6()
    # q7()
    q8()

main()