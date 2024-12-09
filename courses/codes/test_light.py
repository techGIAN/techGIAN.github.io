from Light import Light

print("Running Light tests...")

# 1. Test Light()
n = Light()
assert str(n) == "on white\tnot burnt out"

# 2. Test Light(o, b, c)
n = Light(o=False, b=True, c="green")
assert str(n) == "off green\tburnt out"

# 3. Test burn_out()
n = Light()
n.burn_out()
assert str(n) == "off white\tburnt out"

# 4. Test flip()
n = Light(o=True, b=False, c="white")
assert str(n) == "on white\tnot burnt out"
n.flip()
assert str(n) == "off white\tnot burnt out"
n.flip()
assert str(n) == "on white\tnot burnt out"
n.burn_out()
n.flip()
assert str(n) == "off white\tburnt out"

# 5. Test is_on()
n = Light()
assert n.is_on()
n.flip()
assert not n.is_on()

# 6. Test get_color()
n = Light(c="red")
assert n.get_color() == "red"
n = Light(c="green")
assert n.get_color() == "green"
n = Light(c="blue")
assert n.get_color() == "blue"
n = Light(c="white")
assert n.get_color() == "white"
n = Light(c="purple")
assert n.get_color() == "white"

# 7. Test set_color()
n = Light()
n.set_color("red")
assert n.get_color() == "red"
n.set_color("green")
assert n.get_color() == "green"
n.set_color("blue")
assert n.get_color() == "blue"
n.set_color("white")
assert n.get_color() == "white"
n.set_color("purple")
assert n.get_color() == "white"

print("Tests passed.")




