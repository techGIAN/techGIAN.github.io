import java.util.*;

public class FactorSolitaire {

    public static int cost(int N, int c) {
        if (N == 1) {
            return c;
        } else {
            for (int factor = N; factor > 0; factor--) {
                int val = N - factor;
                if (N % factor == 0 && val >= 1) {
                    return cost(val, c + val / factor);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.println(cost(N, 0));
    }
}