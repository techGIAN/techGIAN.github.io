import java.util.Scanner;

public class Oscillating {
    public static boolean isAlternating(int[] A, int start, int end) {
        if (start == end) return true;
        if (end - start == 1) return (A[start] < A[start + 1] || A[start] > A[start + 1]);

        int mid = (start + end) / 2;
        boolean leftResult = isAlternating(A, start, mid);
        boolean rightResult = isAlternating(A, mid + 1, end);

        if (leftResult && rightResult) {
            if ((A[mid] < A[mid + 1] && A[mid - 1] > A[mid]) || (A[mid] > A[mid + 1] && A[mid - 1] < A[mid])) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println(isAlternating(A, 0, N - 1) ? "oscillating" : "not oscillating");
        scanner.close();
    }
}