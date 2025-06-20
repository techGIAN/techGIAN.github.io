def is_alternating(A: list, start: int, end: int) -> bool:

    if start == end:
        return True
    if end - start == 1:
        return (A[start] < A[start + 1] or A[start] > A[start + 1])
    
    mid = (start + end) // 2
    left_result = is_alternating(A, start, mid)
    right_result = is_alternating(A, mid + 1, end)

    if left_result and right_result:
        if (A[mid] < A[mid + 1] and A[mid - 1] > A[mid]) or (A[mid] > A[mid + 1] and A[mid - 1] < A[mid]):
            return True
        else:
            return False
    else:
        return False
    
N = int(input())
A = [int(x) for x in input().split()]
print("oscillating" if is_alternating(A, 0, len(A)-1) else "not osciallating")