import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class HW5Q1 {

	public static void main(String[] args) {
		
		arrVersion();
		listVersion();
		
	}
	
	public static void arrVersion() {
		// Q1a
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}
		
		// Q1b
		System.out.print("Entered numbers: ");
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// Q1c
		System.out.print("Reversed order: ");
		for (int i = 9; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// Q1d
		System.out.print("Odd numbers: ");
		for (int n : arr) {
			if (n % 2 == 1) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		// Q1e
		System.out.print("Even numbers: ");
		for (int n : arr) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		// Q1fg
		System.out.print("Largest number: ");
		int max = arr[0];
		for (int n : arr) {
			if (n > max) {
				max = n;
			}
		}
		System.out.println(max);
		
		System.out.print("Smallest number: ");
		int min = arr[0];
		for (int n : arr) {
			if (n < min) {
				min = n;
			}
		}
		System.out.println(min);
		
		// Q1g
		System.out.println("Sum of numbers: " + sumArr(arr));
	}
	
	public static int sumArr(int[] A) {
		int s = 0;
		for (int x : A) {
			s += x;
		}
		return s;
	}
	
	public static void listVersion() {
		// Q1a
		Scanner sc = new Scanner(System.in);
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			l.add(num);
		}
		
		// Q1b
		System.out.print("Entered numbers: ");
		for (int n : l) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// Q1c
		System.out.print("Reversed order: ");
		for (int i = 9; i >= 0; i--) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println();
		
		// Q1d
		System.out.print("Odd numbers: ");
		for (int n : l) {
			if (n % 2 == 1) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		// Q1e
		System.out.print("Even numbers: ");
		for (int n : l) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		// Q1fg
		System.out.print("Largest number: ");
		int max = l.get(0);
		for (int n : l) {
			if (n > max) {
				max = n;
			}
		}
		System.out.println(max);
		
		System.out.print("Smallest number: ");
		int min = l.get(0);
		for (int n : l) {
			if (n < min) {
				min = n;
			}
		}
		System.out.println(min);
		
		// Q1g
		System.out.println("Sum of numbers: " + sumList(l));
	}
	
	public static int sumList(List<Integer> l) {
		int s = 0;
		for (int x : l) {
			s += x;
		}
		return s;
	}

}
