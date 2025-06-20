MAX_K = 501
MAX_N = 30000

dp = [[0] * MAX_N for _ in range(MAX_K)]
blocks = [0] * MAX_N

def main():
    t = int(input())

    for _ in range(t):
        n, k, w = map(int, input().split())
        pins = [int(input()) for _ in range(n)]

        # Precompute blocks (window sums of size w)
        blocks[0] = sum(pins[:w])
        for i in range(1, n):
            blocks[i] = blocks[i - 1] - pins[i - 1]
            if i + w - 1 < n:
                blocks[i] += pins[i + w - 1]
            else:
                blocks[i] = 0  # Invalidate partial windows past the end

        # Reset dp for this test case
        for i in range(k + 1):
            for j in range(n):
                dp[i][j] = 0

        # Fill DP table
        for i in range(1, k + 1):
            for j in range(n - 1, -1, -1):
                if j >= n - w:
                    dp[i][j] = blocks[j]
                else:
                    dp[i][j] = max(dp[i - 1][j + w] + blocks[j], dp[i][j + 1])

        print(dp[k][0])

if __name__ == "__main__":
    main()