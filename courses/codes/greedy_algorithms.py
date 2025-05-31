from fractions import Fraction

def egyptian_decomp():
    arr = input().split(" ")
    a, b = int(arr[0]), int(arr[1])
    denoms, q = [], 1
    
    while a > 0:
        if a == 1:
            denoms.append(b)
            break
        while 1/q > a/b:
            q += 1
        x = Fraction(a/b - 1/q).limit_denominator()
        a, b = x.numerator, x.denominator
        denoms.append(q)
    print(' '.join([str(d) for d in denoms]))



def check_conflict(s, e, A):
    for i in range(s, e+1):
        if A[i] == 1:
            return True, A
    
    for i in range(s, e+1):
        A[i] = 1

    return False, A

def scheduling():
    N = int(input())
    jobs = []
    for i in range(N):
        arr = input().split(" ")
        jobs.append((int(arr[0]), int(arr[1]), int(arr[2])))

    jobs.sort(key = lambda x: x[2], reverse=True)
    plans, accepted_jobs = [0]*11, []

    for job in jobs:
        conflict, plans = check_conflict(job[0], job[1], plans)
        if not conflict:
            accepted_jobs.append(job)

    print(sum([j[2] for j in accepted_jobs]))

# assume canonical system
def change_making():
    A = int(input())     # amount
    coins = list(map(int, input().split(" ")))
    coins.sort(reverse=True)

    count = 0
    for coin in coins:
        if A >= coin:
            qty = A // coin
            A -= qty * coin
            count += qty

    print(count)




# scheduling()
# egyptian_decomp()
# change_making()
        


