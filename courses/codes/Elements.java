import java.util.Scanner;

public class Elements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an element: ");
		String element = sc.nextLine();
		String category = "Not one of the first ten elements";
		
		switch (element) {
			case "Hydrogen": 
				category = "Gas";
				break;
			case "Helium": 
				category = "Gas";
				break;
			case "Nitrogen": 
				category = "Gas";
				break;
			case "Oxygen": 
				category = "Gas";
				break;
			case "Fluorine": 
				category = "Gas";
				break;
			case "Neon": 
				category = "Gas";
				break;
			case "Lithium": 
				category = "Metal";
				break;
			case "Beryllium": 
				category = "Semi-conductor";
				break;
			case "Boron": 
				category = "Non-metal";
				break;
			case "Carbon": 
				category = "Metal";
				break;
			default:
				break;
		}
		System.out.println(category);
	}

}
