g = (i*2 for i in range(100))
hundred_evens = tuple(g)
mid_evens = hundred_evens[33:67]
print(mid_evens)