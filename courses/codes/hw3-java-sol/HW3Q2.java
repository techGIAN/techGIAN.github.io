import java.util.Scanner;

public class HW3Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter first weight (in kg): ");
		int kg1 = sc.nextInt();
		System.out.print("Enter first weight (in g): ");
		int g1 = sc.nextInt();
		System.out.print("Enter second weight (in kg): ");
		int kg2 = sc.nextInt();
		System.out.print("Enter second weight (in g): ");
		int g2 = sc.nextInt();
		
		int kg = kg1 + kg2;
		int g = g1 + g2;
		
		if (g >= 1000) {
			kg = g / 1000;
			g = g % 1000;
		}
		
		System.out.println("The sum is " + kg + "kg, " + g + "g.");
	}

}
