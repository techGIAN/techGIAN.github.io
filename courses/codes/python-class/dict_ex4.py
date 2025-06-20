cubes = {i : i**3 for i in range(11)}
more_cubes = {i : i**3 for i in range(11, 21)}

cubes.update(more_cubes)

for k, v in cubes.items():
    print(str(k) + ', ' + str(v))

print(len(cubes))