import java.util.Scanner;

public class HW3Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int x = sc.nextInt();
		System.out.print("Enter second integer: ");
		int y = sc.nextInt();
		
		if (y == 0) {
			System.out.println("The quotient cannot be calculated.");
		} else {
			System.out.println("The quotient is " + (double) x / y);
		}
	}

}
