import java.util.Scanner;

public class HW2Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the power calculator!");
		System.out.print("Enter the base: ");
		double base = sc.nextDouble();
		System.out.print("Enter the exponent: ");
		double exponent = sc.nextDouble();
		
		double power = Math.pow(base, exponent);
		
		int intBase = (int) base;
		int intExp = (int) exponent;
		int intPow = (int) power;
		
		System.out.println(intBase + " to the power of " + intExp + " is " + intPow + ".");
	}

}
