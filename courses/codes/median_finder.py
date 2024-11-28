def insertion_sort(A):
    for i in range(1, len(A)):
        temp = A[i]
        j = i
        while j > 0 and temp < A[j - 1]:
            A[j] = A[j - 1]
            j -= 1
        A[j] = temp
    return A

def selection_sort(A):
    for i in range(len(A) - 1, -1, -1):
        max_val, max_loc = A[0], 0
        for j in range(1, i):
            if max_val < A[j]:
                max_val, max_loc = A[j], j
        A[i], A[max_loc] = A[max_loc], A[i]
    return A

def bubble_sort(A):
    for i in range(len(A) - 1, -1, -1):
        for j in range(i):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]
    return A

n = int(input())
nums = []
while n > 0:
    nums.append(n)
    nums = insertion_sort(nums)     # can be any of the three sorting algorithms
    if len(nums) % 2 == 1:
        median = nums[len(nums) // 2]
    else:
        median = (nums[len(nums) // 2 - 1] + nums[len(nums) // 2]) / 2
        if median == int(median):
            median = int(median)
    print("The median so far is " + str(median) + ".")
    n = int(input())
print("End of program.")