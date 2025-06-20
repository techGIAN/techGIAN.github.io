import java.util.Scanner;

public class Gravitation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double G = 6.6743 * Math.pow(10, -11);
		double m1 = 5.972 * Math.pow(10, 24);
		double r = 6.371 * Math.pow(10, 6);
		
		System.out.print("mass (kg): ");
		double m2 = sc.nextDouble();
		
		double num = G * m1 * m2;
		double denom = Math.pow(r, 2);
		double F = num / denom;
		
		System.out.println("The gravitational force (N): " + F);
	}

}
