import java.util.*;

public class CompCan {
    // Method to print matrix
    public static void printMatrix(int[][] M, int ov, int nv) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int v = (M[i][j] == ov) ? nv : M[i][j];
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    // Floyd-Warshall Algorithm
    public static int[][] floydWarshall(int[][] W) {
        int n = W.length;
        int INF = Integer.MAX_VALUE / 2; // Avoid overflow
        
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(D[i], INF);
        }

        // Copy initial weights
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (W[i][j] > 0) {
                    D[i][j] = W[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            D[i][i] = 0;
        }

        // Floyd-Warshall logic
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] < INF && D[k][j] < INF) {
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }
        }
        
        return D;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] W = new int[N][N];

        for (int i = 0; i < M; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            W[from][to] = weight;
        }

        int[][] D = floydWarshall(W);
        printMatrix(D, Integer.MAX_VALUE / 2, -1);
        
        scanner.close();
    }
}