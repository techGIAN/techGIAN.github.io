import java.util.Scanner;

public class HW3Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of hours worked : ");
		int hrs = sc.nextInt();
		System.out.print("Enter the cost of parts : ");
		double cost = sc.nextDouble();
		
		double price = hrs * 100 + cost;
		
		if (price < 150) {
			price = 150;
		}
		
		System.out.println(String.format("The total cost for the job is $%.2f", price));
	}

}
