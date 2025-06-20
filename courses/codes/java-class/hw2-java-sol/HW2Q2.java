import java.util.Scanner;

public class HW2Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int x = sc.nextInt();
		System.out.print("Enter the second number: ");
		int y = sc.nextInt();
		
		double doubleX = (double) x;
		double actual = doubleX / y;
		
		int intDiv = x / y;
		int rem = x % y;
		
		System.out.println(x + " divided by " + y + " is " + actual);
		System.out.println(y + " goes into " + x + " ... " + intDiv + " times, with a remainder of " + rem);
	}

}
