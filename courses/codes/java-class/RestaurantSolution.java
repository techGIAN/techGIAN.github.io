import java.util.Scanner;

public class RestaurantSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What time does the restaurant open? ");
		int openTime = Integer.parseInt(sc.nextLine());
		System.out.print("What time does the restaurant close? ");
		int closeTime = Integer.parseInt(sc.nextLine());
		
		System.out.println(String.format("\nIt's already %d:00, we are now open for business!\n", openTime));
		
		for (int i = openTime*4; i < closeTime*4; i++) {
			
			int guestNum = i - openTime*4 + 1;
			
			System.out.println(String.format("Guest #%d, Welcome to Alix's Restaurant!", guestNum));
			System.out.print("Please select your desired combo meal (1, 2, 3, 4): ");
			int combo = Integer.parseInt(sc.nextLine());
			
			
			double price = 0.0;
			boolean hasOrdered = false;
			while (!hasOrdered) {
				switch(combo) {
					case 1:
						price = 8.23;
						hasOrdered = true;
						break;
					case 2:
						price = 7.97;
						hasOrdered = true;
						break;
					case 3:
						price = 7.05;
						hasOrdered = true;
						break;
					case 4:
						price = 6.71;
						hasOrdered = true;
						break;
					default:
						System.out.println("I'm sorry, that is not in our menu.");
						System.out.print("Please select your desired combo meal (1, 2, 3, 4): ");
						combo = Integer.parseInt(sc.nextLine());
						hasOrdered = false;
				}
			}
			
			System.out.print(String.format("That will be $%.2f please. How much would you pay: ", price));
			double cash = Double.parseDouble(sc.nextLine());
			
			while (price > cash) {
				System.out.println("The amount is not enough. Please try again.");
				System.out.print(String.format("That will be $%.2f please. How much would you pay: ", price));
				cash = Double.parseDouble(sc.nextLine());
			}
			
			double change = cash - price;
			
			if (change == 0) {
				System.out.println("Thank you for paying the exact amount. Please come again.\n");
			} else {
				System.out.println(String.format("Thank you; $%.2f is your change. Please come again.\n", change));
			}
		}
		
	}

}
