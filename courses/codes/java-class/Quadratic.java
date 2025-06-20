import java.util.Scanner;

public class Quadratic {

	public static void main(String[] args) {
		
		// These code are in the previous exercise
		// int a = 1;
		// int b = 15;
		// int c = 50;
		
		// Now we update the program so that we get user input
		// We use a scanner to do it
		Scanner sc = new Scanner(System.in);
		
		// Obtain a, b, and c user input
		System.out.print("a value: ");
		int a = sc.nextInt();
		System.out.print("b value: ");
		int b = sc.nextInt();
		System.out.print("c value: ");
		int c = sc.nextInt();
		
		// Calculate the discriminant D
		double D = Math.pow(b, 2) - 4 * a * c;
		
		// Calculate the two solutions based on the quadratic formula
		double x1 = (-b + Math.sqrt(D))/(2 * a);
		double x2 = (-b - Math.sqrt(D))/(2 * a);
		
		// Print the two solutions
		System.out.println(x1);
		System.out.println(x2);
		
		// Here we printed the solutions without formatting
		// You can choose to format it if you like
	}

}
