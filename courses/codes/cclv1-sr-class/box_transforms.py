import sys

def main():
    n = int(sys.stdin.readline().strip())
    a = list(map(int, sys.stdin.readline().split()))
    b = list(map(int, sys.stdin.readline().split()))

    key_positions = []
    target = b[0]
    A_index = 0

    i = 0
    while i < n:
        while i < n and b[i] == target:
            i += 1
        while A_index < n and a[A_index] != target:
            A_index += 1
        if A_index >= n:
            print("NO")
            return
        key_positions.append((target, A_index))
        if i < n:
            target = b[i]

    print("YES")

    loyal_moves = []
    loyal = 0
    target = b[0]
    key_index = 0

    i = 0
    while i < n and key_index < len(key_positions):
        while i < n and b[i] == target:
            i += 1
        if key_positions[key_index][1] > loyal:
            loyal_moves.append((loyal, key_positions[key_index][1]))
        if i < n:
            target = b[i]
        loyal = i
        key_index += 1

    royal_moves = []
    royal = n - 1
    target = b[n - 1]
    key_index = len(key_positions) - 1

    i = n - 1
    while i >= 0 and key_index >= 0:
        while i >= 0 and b[i] == target:
            i -= 1
        if key_positions[key_index][1] < royal:
            royal_moves.append((key_positions[key_index][1], royal))
        if i >= 0:
            target = b[i]
        royal = i
        key_index -= 1

    print(len(loyal_moves) + len(royal_moves))
    for l, r in loyal_moves:
        print(f"L {l + 1} {r + 1}")
    for l, r in royal_moves:
        print(f"R {l + 1} {r + 1}")

if __name__ == "__main__":
    main()