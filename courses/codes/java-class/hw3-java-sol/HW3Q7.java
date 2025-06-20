import java.util.Scanner;

public class HW3Q7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int countOdd = 0;		// counts all odd integers seen so far
		int sumOdd = 0;			// adds all odd integers seen so far
		
		System.out.println("Please enter integers: ");
		int n = sc.nextInt();
		
		while (n != 0) {
			
			int absN = (n >= 0) ? n : -n;
			
			if (absN % 2 == 1) {		// checks if absolute n is odd
				countOdd++;
				sumOdd += n;
			}
			
			n = sc.nextInt();
		}
		
		if (countOdd == 0) {
			System.out.println(0);
		} else {
			double average = (double) sumOdd / countOdd;
			System.out.println(average);
		}
	}

}
