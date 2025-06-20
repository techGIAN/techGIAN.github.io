import math

def calculate_rectangle_area(width, length):
    """
    This function calculates the area of a rectangle
    :param float width: the width
    :param float length: the length
    :return returns the area of a rectangle given the length and width
    """
    return width * length

def calculate_triangle_area(base, height):
    """
    This function calculates the area of a triangle
    :param float base: the base
    :param float height: the height
    :return returns the area of a triangle given the base and height
    """
    return base * height / 2

def calculate_circle_area(radius):
    """
    This function calculates the area of a circle
    :param float radius: the radius
    :return returns the area of a circle given the radius
    """
    return math.pi * radius ** 2

def calculate_sphere_area(radius):
    """
    This function calculates the surface area of a sphere
    :param float radius: the radius
    :return returns the surface area of a sphere given the radius
    """
    return 4 * math.pi * radius ** 2

def calculate_cuboid_volume(height, width, length):
    """
    This function calculates the area of a rectangle
    :param float height: the height
    :param float width: the width
    :param float length: the length
    :return returns the volume of a cuboid given the length and width and height
    """
    return width * length * height