M = int(input())        # number of cookie types
N = int(input())        # the number of students

cookie_size = dict()        # keys are the cookie type, values are cookie size

for i in range(1, M+1):
    cookie_size[i] = input()    # each value will be a char 'S', 'M', or 'L'

# which cookie sizes will satisfy a student given their preferred size
satisfiable_size = {
    'L': ['L'],
    'M': ['M', 'L'],
    'S': ['S', 'M', 'L']
}

thumbs_up = 0           # how many students will give a thumbs up

for j in range(1, N+1):
    arr = input().split(" ")
    preferred_size = arr[0]
    preferred_type = int(arr[1])

    if preferred_type not in cookie_size:       # can't satisfy student if it is not preferred type
        continue                                # move on to the next student

    size = cookie_size[preferred_type]          # get the size of the preferred_type

    if size in satisfiable_size[preferred_size]:
        thumbs_up += 1
        del cookie_size[preferred_type]      # make sure to remove cookie as no other student can get it anymore

print(thumbs_up)
