import java.util.Scanner;

public class SpecialStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		
		while (s.charAt(0) != 's' && s.charAt(0) != 'S') {
			System.out.print("Enter a string: ");
			s = sc.nextLine();
		}
		
		System.out.println("Program terminated.");
	}

}
