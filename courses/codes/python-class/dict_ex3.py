cubes = {i : i**3 for i in range(41)}
evens = {i for i in range(41) if i % 2 == 0}

for e in evens:
    cubes.pop(e)

for k, v in cubes.items():
    print(str(k) + ', ' + str(v))