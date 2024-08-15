import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class HW6Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> s = new HashSet<>();
		int num = sc.nextInt();
		while (num > -1) {
			s.add(num);
			num = sc.nextInt();
		}
		
		int sumOfEvens = 0;
		int countOdds = 0;
		
		System.out.print("Entered numbers: ");
		for (Integer n : s) {
			if (n % 2 == 0) {
				sumOfEvens += n;
			} else {
				countOdds++;
			}
			System.out.print(n + " ");
		}
		
		System.out.println("Sum of even numbers: " + sumOfEvens);
		System.out.println("Odd number count: " + countOdds);
		
		sc.close();
	}

}
