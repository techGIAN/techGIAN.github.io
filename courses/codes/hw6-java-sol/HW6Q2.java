import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class HW6Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> s = new HashSet<>();
		int num = sc.nextInt();
		while (num > -1) {
			s.add(num);
			num = sc.nextInt();
		}
		
		System.out.print("Non-primes: ");
		Set<Integer> newSet = new HashSet<>(s);
		for (Integer n : newSet) {
			
			if (n % 2 == 0) {
				s.remove(n);
			}
			
			if (n % 3 == 0) {
				s.remove(n);
			}
			
			if (n % 5 == 0) {
				s.remove(n);
			}
			
			if (n % 7 == 0) {
				s.remove(n);
			}
			
			if (n % 11 == 0) {
				s.remove(n);
			}
			
		}
		
		newSet.removeAll(s);
		
		for (Integer n : newSet) {
			System.out.print(n + " ");
		}
		
		sc.close();
	}

}
