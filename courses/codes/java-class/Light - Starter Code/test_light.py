import unittest
from Light import Light

class TestLight(unittest.TestCase):

    def setup(self):
        self.light = Light()

class TestInit(TestLight):

    # 1. Test Light()
    def test_light(self):
        self.light = Light()
        self.assertEqual(str(self.light), "on white\tnot burnt out")

    # 2. Test Light(o, b, c)
    def test_light2(self):
        self.light = Light(o=False, b=True, c="green")
        self.assertEqual(str(self.light), "off green\tburnt out")

class TestMethods(TestLight):

    # 3. Test burn_out()
    def test_burn_out(self):
        self.light = Light()
        self.light.burn_out()
        self.assertEqual(str(self.light), "off white\tburnt out")
    
    # 4. Test flip()
    def test_flip(self):
        self.light = Light(o=True, b=False, c="white")
        self.assertEqual(str(self.light), "on white\tnot burnt out")

        self.light.flip()
        self.assertEqual(str(self.light), "off white\tnot burnt out")

        self.light.flip()
        self.assertEqual(str(self.light), "on white\tnot burnt out")

        self.light.burn_out()
        self.light.flip()
        self.assertEqual(str(self.light), "off white\tburnt out")  

    # 5. Test is_on()
    def test_is_on(self):
        self.light = Light()
        self.assertTrue(self.light.is_on())

        self.light.flip()
        self.assertFalse(self.light.is_on())

    # 6. Test get_color()
    def test_get_color(self):
        self.light = Light(c="red")
        self.assertEqual(self.light.get_color(), "red")

        self.light = Light(c="green")
        self.assertEqual(self.light.get_color(), "green")

        self.light = Light(c="blue")
        self.assertEqual(self.light.get_color(), "blue")

        self.light = Light(c="white")
        self.assertEqual(self.light.get_color(), "white")

        self.light = Light(c="purple")
        self.assertEqual(self.light.get_color(), "white")

    # 7. Test set_color()
    def test_set_color(self):
        self.light = Light()

        self.light.set_color("red")
        self.assertEqual(self.light.get_color(), "red")

        self.light.set_color("green")
        self.assertEqual(self.light.get_color(), "green")

        self.light.set_color("blue")
        self.assertEqual(self.light.get_color(), "blue")

        self.light.set_color("white")
        self.assertEqual(self.light.get_color(), "white")

        self.light.cset_color("purple")
        self.assertEqual(self.light.get_color(), "white")

if __name__ == '__main__':
    unittest.main()