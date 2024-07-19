import java.util.Scanner;

public class HW2Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a weight in kilograms: ");
		int kg = sc.nextInt();
		double lbs = kg * 2.20462;
		System.out.println("The equivalent amount in pounds is " + lbs + " lbs.");
	}

}
