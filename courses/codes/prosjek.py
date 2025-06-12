import heapq

N = int(input())
scores = [int(input()) for _ in range(N)]

# Convert to min heap
heapq.heapify(scores)

while len(scores) > 1:
    x1 = heapq.heappop(scores)
    x2 = heapq.heappop(scores)
    avg = (x1 + x2) / 2
    heapq.heappush(scores, avg)

print(f"{scores[0]:.6f}")