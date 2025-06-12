import math

# Finding all factors is slow...
# Can apply recursion to find "some" factors
def cost(N, c):
    if N == 1:
        return c
    for factor in range(N, 0, -1):
        val =  N - factor
        if N % factor == 0 and val >= 1:
            return cost(val, c + val // factor)
        
N = int(input())
print(cost(N, 0))