import java.util.Scanner;
import java.util.Arrays;

public class Bowling {
    static int n, k, w;
    static int[][] dp = new int[501][30000];
    static int[] blocks = new int[30000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            w = sc.nextInt();

            int[] pins = new int[n];
            int total = 0;

            for (int i = 0; i < n; i++) {
                pins[i] = sc.nextInt();
                total += pins[i];
            }

            // Precompute blocks (windows of size w)
            blocks[0] = 0;
            for (int i = 0; i < w; i++) {
                blocks[0] += pins[i];
            }

            for (int i = 1; i < n; i++) {
                blocks[i] = blocks[i - 1] - pins[i - 1];
                if (i + w - 1 < n) {
                    blocks[i] += pins[i + w - 1];
                }
            }

            // Reset dp
            for (int[] row : dp) {
                Arrays.fill(row, 0);
            }

            for (int i = 1; i <= k; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (j >= n - w) {
                        dp[i][j] = blocks[j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j + w] + blocks[j], dp[i][j + 1]);
                    }
                }
            }

            System.out.println(dp[k][0]);
        }

        sc.close();
    }
}