import java.util.Scanner;

public class HW2Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many toonies do you have? ");
		int toonies = sc.nextInt();
		
		System.out.print("How many loonies do you have? ");
		int loonies = sc.nextInt();
		
		System.out.print("How many quarters do you have? ");
		int quarters = sc.nextInt();
		
		System.out.print("How many dimes do you have? ");
		int dimes = sc.nextInt();
		
		System.out.print("How many nickels do you have? ");
		int nickels = sc.nextInt();
		
		double money = toonies * 2 + loonies + quarters * 0.25 + dimes * 0.10 + nickels * 0.05;
		
		System.out.println(String.format("The total value of your coins comes up to be $%.2f", money));
	}

}
