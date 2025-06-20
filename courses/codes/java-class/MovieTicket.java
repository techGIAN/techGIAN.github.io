import java.util.Scanner;

public class MovieTicket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = Integer.parseInt(sc.nextLine());
		
		// Exercise 1
//		double price = 8.95;
//		
//		if (age >= 65) {
//			price *= 0.8;
//		}
		
		
		// Exercise 2
		double price = 8.0;
		
		if (age <= 12) {
			price *= 0.9;
		}
		
		System.out.println(String.format("The movie ticket costs $%.2f", price));
		
		if (age > 12) {
			System.out.println("Sorry, you do not qualify for the discount.");
		}
	}

}
