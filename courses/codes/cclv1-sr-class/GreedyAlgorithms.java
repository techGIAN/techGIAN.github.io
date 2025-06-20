
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreedyAlgorithms {

    public static void egyptianDecomp() {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        List<Integer> denoms = new ArrayList<>();
        int q = 1;

        while (a > 0) {
            if (a == 1) {
                denoms.add(b);
                break;
            }
            while (1.0 / q > (double) a / b) {
                q++;
            }
            int num = a * q - b;
            int denom = b * q;
            int gcd = gcd(num, denom);
            num /= gcd;
            denom /= gcd;
            a = num;
            b = denom;
            denoms.add(q);
        }
        for (int d : denoms) {
            System.out.print(d + " ");
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void checkConflict(int s, int e, int[] A) {
        for (int i = s; i <= e; i++) {
            if (A[i] == 1) {
                return;
            }
        }
        for (int i = s; i <= e; i++) {
            A[i] = 1;
        }
    }

    public static void scheduling() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][] jobs = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] arr = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                jobs[i][j] = Integer.parseInt(arr[j]);
            }
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));
        int[] plans = new int[11];
        List<int[]> acceptedJobs = new ArrayList<>();

        for (int[] job : jobs) {
            boolean conflict = false;
            for (int i = job[0]; i <= job[1]; i++) {
                if (plans[i] == 1) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict) {
                acceptedJobs.add(job);
                for (int i = job[0]; i <= job[1]; i++) {
                    plans[i] = 1;
                }
            }
        }

        int total = acceptedJobs.stream().mapToInt(job -> job[2]).sum();
        System.out.println(total);
    }

    public static void changeMaking() {
        Scanner scanner = new Scanner(System.in);
        int A = Integer.parseInt(scanner.nextLine());
        String[] coinsStr = scanner.nextLine().split(" ");
        int[] coins = new int[coinsStr.length];
        for (int i = 0; i < coinsStr.length; i++) {
            coins[i] = Integer.parseInt(coinsStr[i]);
        }
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (A >= coins[i]) {
                int qty = A / coins[i];
                A -= qty * coins[i];
                count += qty;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        // Uncomment the method calls for testing each function
//         scheduling();
//         egyptianDecomp();
//         changeMaking();
    }
}
