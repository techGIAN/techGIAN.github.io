import java.util.Scanner;

public class KineticEnergy {

	public static void main(String[] args) {
		// Example:
		// m_1=25.2 kg
		// v_1=34.7 m/s
		// m_2=32.9 kg
		// v_2=29.8 m/s
		// KE = 29,779.792 J

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter object 1's mass: ");
		double m1 = sc.nextDouble();
		
		System.out.print("Enter object 1's speed: ");
		double v1 = sc.nextDouble();
		
		System.out.print("Enter object 2's mass: ");
		double m2 = sc.nextDouble();
		
		System.out.print("Enter object 2's speed: ");
		double v2 = sc.nextDouble();
		
		double ke1 = 0.5 * m1 * v1 * v1;
		double ke2 = 0.5 * m2 * v2 * v2;
		double ke = ke1 + ke2;
		
		System.out.println("The total kinetic energy of the objects is: " + ke + " J.");
		
		sc.close();
	}

}
