import java.util.Scanner;
import java.util.Arrays;

public class MedianFinder {

	public static int[] insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int temp = A[i];
			int j = i;
			while (j > 0 && temp < A[j - 1]) {
				A[j] = A[j - 1];
				j--;
			}
			A[j] = temp;
		}
		return A;
	}
	
	public static int[] selectionSort(int[] A) {
		for (int i = A.length - 1; i > 0; i--) {
			int max = A[0];
			int maxLoc = 0;
			for (int j = 1; j <= i; j++) {
				if (max < A[j]) {
					max = A[j];
					maxLoc = j;
				}
			}
			int temp = A[i];
			A[i] = A[maxLoc];
			A[maxLoc] = temp;
		}
		return A;
	}
	
	public static int[] bubbleSort(int[] A) {
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		return A;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[1];
		while (n > 0) {
			int lastSpot = nums.length - 1;
			nums[lastSpot] = n;
			nums = insertionSort(nums);		// feel free to use any sorting algorithm
			
			if (nums.length % 2 == 1) {
				System.out.println("The median so far is " + nums[nums.length / 2] + ".");
			} else {
				double num1 = (double) nums[nums.length / 2 - 1];
				double num2 = (double) nums[nums.length / 2];
				double med = (num1 + num2) / 2;
				int intMed = (int) med;
				if (med == intMed) {
					System.out.println("The median so far is " + intMed + ".");
				} else {
					System.out.println("The median so far is " + med + ".");
				}
			}
			n = sc.nextInt();
			int[] tempArr = new int[nums.length + 1];
			System.arraycopy(nums, 0, tempArr, 0, nums.length);
			nums = new int[nums.length + 1];
			System.arraycopy(tempArr, 0, nums, 0, tempArr.length);
		}
		System.out.println("End of program.");
	}

}
