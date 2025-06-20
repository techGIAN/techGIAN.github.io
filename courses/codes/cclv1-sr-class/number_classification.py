import math


def is_prime(n):
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

def prime_factorize(n):

    d = dict()
    for i in range(2, n):
        if (is_prime(i)):
            pow, temp = 0, n
            while (temp % i == 0):
                pow += 1
                temp /= i
            if pow > 0:
                d[i] = pow
    return d

def get_proper_factors(d):
    num_of_factors = math.prod([v+1 for k, v in d.items()])

    proper_factors = []
    combinations = generate_combinations(get_combinations(d))
    for combination in combinations:
        proper_factors.append(math.prod(combination))
    proper_factors.sort()
    return proper_factors[:-1]

def type_of_num(n):
    d = prime_factorize(n)
    proper_factors = get_proper_factors(d)
    sum_of_factors = sum(proper_factors)

    if sum_of_factors < n:
        return 'a deficient'
    elif sum_of_factors > n:
        return 'an abundant'
    else:
        return 'a perfect'

def get_combinations(d):
    pairsSet = []
    for k,v in d.items():
        pows = []
        for i in range(v+1):
            pows.append(k ** i)
        pairsSet.append(pows)
    return pairsSet

def generate_combinations(sets):
    def generate_combinations_helper(sets, result, current_combination, index):
        if index == len(sets):
            result.append(list(current_combination))
            return

        for element in sets[index]:
            current_combination.append(element)
            generate_combinations_helper(sets, result, current_combination, index + 1)
            current_combination.pop()

    result = []
    generate_combinations_helper(sets, result, [], 0)
    return result


N = int(input())
for _ in range(N):
    n = int(input())
    type = type_of_num(n)
    print(f'{n} is {type} number.')

