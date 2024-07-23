
public class Geometry {
	
	/**
	* This function calculates the area of a rectangle.
	* @param width the width
	* @param length the length
	* @return the rectangle area
	*/
	public static double calculateRectangleArea(double width, double length) {
        return width * length;
    }
	
	/**
	* This function calculates the area of a triangle.
	* @param base the base
	* @param height the height
	* @return the triangle area
	*/
	public static double calculateTriangleArea(double base, double height) {
        return base * height / 2.0;
    }
	
	/**
	* This function calculates the area of a circle.
	* @param radius the radius
	* @return the circle area
	*/
	public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
	
	/**
	* This function calculates the surface area of a sphere.
	* @param radius the radius
	* @return the sphere surface area
	*/
	public static double calculateSphereArea(double radius) {
        return 4 * Math.PI * radius * radius;
    }
	
	/**
	* This function calculates the volume of a cuboid.
	* @param width the width
	* @param length the length
	* @param height the height
	* @return the cuboid volume
	*/
	public static double calculateCuboidVolume(double length, double width, double height) {
        return height * width * length;
    }
	
	/**
	* This function calculates the volume of a sphere.
	* @param radius the radius
	* @return the sphere volume
	*/
	public static double calculateSphereVolume(double radius) {
        return 4 * Math.PI * radius * radius * radius / 3;
    }
	
	public static void main(String[] args) {
		System.out.println("Area of rectangle with width 3.0 and length 5.0 is " + String.format("%.2f", calculateRectangleArea(3.0, 5.0)));
		
		System.out.println("Area of triangle with base 3.5 and height 6.2 is " + String.format("%.2f", calculateTriangleArea(3.5, 6.2)));
		
		System.out.println("Area of circle with radius 4.8 is " + String.format("%.2f", calculateCircleArea(4.8)));
		
		System.out.println("Surface area of sphere with radius 3.3 is " + String.format("%.2f", calculateSphereArea(3.3)));
		
		System.out.println("Volume of cuboid with length 1.7, width 2.9, and height 4.3 is " + String.format("%.2f", calculateCuboidVolume(1.7, 2.9, 4.3)));
		
		System.out.println("Volume of sphere with radius 3.2 is " + String.format("%.2f", calculateSphereVolume(3.2)));
	}
}
