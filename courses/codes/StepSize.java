import java.util.Scanner;

public class StepSize {

	// In-class Exercise 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int p = sc.nextInt();
		System.out.print("Enter a negative integer: ");
		int n = sc.nextInt();
		System.out.print("Enter a positive step-size integer: ");
		int s = sc.nextInt();
		
		int sum = 0;
		for (int i = n; i <= p; i += s) {
			sum += i;
		}
		System.out.println(sum);
	}

}
