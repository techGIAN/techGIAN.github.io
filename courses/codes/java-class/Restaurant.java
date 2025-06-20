// Exercise: Download and import to Eclipse
// Fill in the blanks

import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
		
		// create a Scanner object
		Scanner sc = new Scanner(System.in);
		
		// ask the user for the time the restaurant opens and closes
		// this determines how many guests there will be
		// assume that one guest per 15 mins
		System.out.print("What time does the restaurant open? ");
		int openTime = Integer.parseInt(sc.nextLine());
		System.out.print("What time does the restaurant close? ");
		int closeTime = Integer.parseInt(sc.nextLine());
		
		System.out.println(String.format("\nIt's already %d:00, we are now open for business!\n", openTime));
		
		// for each guest, display their guest number, ask them what they would like to have, display the cost of the meal,
		// 		ask for how much will their payment be, and display their change
		for (int i = openTime*4; i < __________; i++) {
			
			// calculate the guest number
			int guestNum = i - openTime*4 + 1;
			
			
			// prompt the user for their desired combo meal
			System.out.println(String.format("Guest #%d, Welcome to Alix's Restaurant!", guestNum));
			System.out.print("Please select your desired combo meal (1, 2, 3, 4): ");
			int combo = Integer.parseInt(sc.nextLine());
			
			// Declare price and hasOrdered, initialize their values to be 0 and false respectively
			// Run a loop until the customer has ordered. i.e., keep repeating the following steps while the user has not ordered yet:
			// 		1. Set the price of the meal based on user order (only if the combo order was 1, 2, 3, or 4).
			//		2. Change hasOrdered to be true (only if the combo order was 1, 2, 3, or 4); this indicates the user has already ordered
			//		3. If the user inputs an invalid order (other than 1, 2, 3, or 4), then print a message saying so, and prompt for another user input
			double price = __________;
			boolean hasOrdered = __________;
			while (__________) {
				switch(__________) {
					case 1:
						price = __________;
						hasOrdered = __________;
						__________;
					case 2:
						price = __________;
						hasOrdered = __________;
						__________;
					case 3:
						price = __________;
						hasOrdered = __________;
						__________;
					case 4:
						price = __________;
						hasOrdered = __________;
						__________;
					default:
						System.out.println("I'm sorry, that is not in our menu.");
						System.out.print("Please select your desired combo meal (1, 2, 3, 4): ");
						combo = Integer.parseInt(sc.nextLine());
						hasOrdered = false;
				}
			}
			
			// Display the cost of the meal.
			// Then ask the user how much they are going to pay
			System.out.print(String.format("That will be $%.2f please. How much would you pay: ", price));
			double cash = Double.parseDouble(sc.nextLine());
			
			// If the user enters an amount less than the price of the meal, display the error message
			// Then ask the user to enter another amount;
			// keep on asking for an amount until the user enters an amount at least as great as the price of the meal
			while (__________) {
				System.out.println("The amount is not enough. Please try again.");
				System.out.print(String.format("That will be $%.2f please. How much would you pay: ", price));
				cash = Double.parseDouble(sc.nextLine());
			}
			
			// Calculate the change
			double change = __________;
			
			// Display the change
			// If the amount paid was exact, display an error message saying it so
			if (__________) {
				System.out.println("Thank you for paying the exact amount. Please come again.\n");
			} else {
				System.out.println(String.format("Thank you; $%.2f is your change. Please come again.\n", change));
			}
		}
		
	}

}
