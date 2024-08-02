import java.util.Set;
import java.util.HashSet;

public class SetExercises {

	public static void main(String[] args) {
//		// Ex 1
//		Set<Integer> smallPrimes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//		for (Integer x : smallPrimes) {
//			System.out.println(x);
//		}
//		
//		// Ex 2
//		Set<Integer> tenEvens = new HashSet<>();
//		for (int i = 0; i < 10; i++) {
//			tenEvens.add(2*i);
//		}
//		System.out.println(tenEvens);
//		System.out.println(tenEvens.size());
//		for (int i = 20; i < 30; i+=2) {
//			tenEvens.add(i);
//		}
//		System.out.println(tenEvens);
//		System.out.println(tenEvens.size());
//		
//		// Ex 3
//		Set<Integer> numbers = new HashSet<>();
//		for (int i = 1; i < 21; i++) {
//			numbers.add(i);
//		}
//		numbers.remove(1);
//		for (int i = 2; i < 21; i++) {
//			if (i % 2 == 0 && i != 2) {
//				numbers.remove(i);
//			}
//			if (i % 3 == 0 && i != 3) {
//				numbers.remove(i);
//			}
//			if (i % 5 == 0 && i != 5) {
//				numbers.remove(i);
//			}
//		}
//		System.out.println(numbers);
//		System.out.println(numbers.size());
		
//		// Ex 4
//		Set<Integer> numbers = new HashSet<>();
//		for (int i = 0; i < 41; i++) {
//			numbers.add(i);
//		}
//		Set<Integer> evens = new HashSet<>();
//		for (int i = 0; i < 41; i+=2) {
//			evens.add(i);
//		}
//		for (Integer x : evens) {
//			numbers.remove(x);
//		}
//		System.out.println(numbers);
//		
//		// Ex 5
//		Set<Integer> fortyEvens = new HashSet<>();
//		for (int i = 0; i < 41; i+=2) {
//			fortyEvens.add(i);
//		}
//		Set<Integer> fortyOdds = new HashSet<>();
//		for (int i = 1; i < 41; i+=2) {
//			fortyOdds.add(i);
//		}
//		Set<Integer> forty = new HashSet<>(fortyEvens);
//		forty.addAll(fortyOdds);
//		System.out.println(forty);
//		System.out.println(fortyEvens);
//		System.out.println(fortyOdds);
		
		// Ex 6
		Set<Integer> forty = new HashSet<>();
		for (int i = 0; i < 41; i++) {
			forty.add(i);
		}
		Set<Integer> fortyEvens = new HashSet<>();
		for (int i = 0; i < 41; i+=2) {
			fortyEvens.add(i);
		}
		Set<Integer> fortyOdds = new HashSet<>(forty);
		fortyOdds.removeAll(fortyEvens);
		System.out.println(forty);
		System.out.println(fortyEvens);
		System.out.println(fortyOdds);
		
		
	}

}
