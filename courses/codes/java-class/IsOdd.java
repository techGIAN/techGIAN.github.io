import java.util.Scanner;

public class IsOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = sc.nextInt();
		// One liner way: boolean isOdd = (n & 1) == 1;
		
		// Note: n is even iff its last bit is 0
		// and n is odd iff its last bit is 1
		// the binary of 1 is 000..01 (have as many zeros as needed)
		// then doing a bitwise AND will result into either:
		// a 1 at the end (meaning n is odd) OR
		// a 0 at the end (meaning n is even)
		int bitwiseAnd = n & 1;
		
		// check if bitwiseAnd is 1
		// if it is, then its value is true; false otherwise
		boolean isOdd = (bitwiseAnd == 1);
		
		System.out.println("The integer " + n + " is odd: " + isOdd);
		
	}

}
