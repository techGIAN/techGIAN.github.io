
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberClassification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			sc.nextLine();
			String type = typeOfNum(n);
			System.out.println(n + " is " + type + " number.");
		}
	}
	
	public static int sumOfFactors(int[] factors) {
		int sum = 0;
		for (int f : factors) {
			sum += f;
		}
		return sum;
	}
	
	public static String typeOfNum(int n) {
		Map<Integer, Integer> m = primeFactorize(n);
		int[] properFactors = getProperFactors(m);
		int sumOfProperFactors = sumOfFactors(properFactors);
		
		if (sumOfProperFactors < n) {
			return "a deficient";
		} else if (sumOfProperFactors > n) {
			return "an abundant";
		} else {
			return "a perfect";
		}
	}
	
	public static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static Map<Integer, Integer> primeFactorize(int n) {
		
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				int pow = 0;
				int temp = n;
				while (temp % i == 0) {
					pow += 1;
					temp = temp / i;
				}
				if (pow > 0) {
					m.put(i, pow);
				}
			}
		}
		return m;
	}
	
	public static int[] getProperFactors(Map<Integer, Integer> m) {
		
		int numOfFactors = 1;
		for (Entry<Integer, Integer> e : m.entrySet()) {
			numOfFactors = numOfFactors * (e.getValue() + 1);
		}
		
		int[] properFactors = new int[numOfFactors];
		int i = 0;
		
		List<List<Integer>> combinations = generateCombinations(getCombinations(m));
        for (List<Integer> combination : combinations) {
            properFactors[i] = prodCombination(combination);
            i += 1;
        }
        Arrays.sort(properFactors);
        return Arrays.copyOfRange(properFactors, 0, properFactors.length-1);
        
	}
	
	public static int prodCombination(List<Integer> l) {
		int prod = 1;
		for (Integer i : l) {
			prod *= i;
		}
		return prod;
	}
	
	public static List<List<Integer>> getCombinations(Map<Integer, Integer> m) {
		List<List<Integer>> pairsSet = new ArrayList<>();
		for (Entry<Integer, Integer> e : m.entrySet()) {
			int key = e.getKey();
			int val = e.getValue();
			
			List<Integer> s = new ArrayList<>();
			for (int i = 0; i <= val; i++) {
				Integer value = (int) Math.pow(key, i);
				s.add(value);
			}
			pairsSet.add(s);
		}
		return pairsSet;
		
	}
	
	public static List<List<Integer>> generateCombinations(List<List<Integer>> sets) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsHelper(sets, result, new ArrayList<>(), 0);
        return result;
    }

    private static void generateCombinationsHelper(List<List<Integer>> sets, List<List<Integer>> result,
                                                    List<Integer> currentCombination, int index) {
        if (index == sets.size()) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (Integer element : sets.get(index)) {
            currentCombination.add(element);
            generateCombinationsHelper(sets, result, currentCombination, index + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
	
	
	
}