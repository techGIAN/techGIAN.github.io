
public class HW6Q4 {

	public static void main(String[] args) {
        pascal(10);
    }

    public static void pascal(int n) {
        for (int i = 1; i <= n; i++) {
            int[] arr = row(i);
            for (int j = 0; j < i; j++) {
                System.out.print(arr[j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[] row(int n) {
        int[] r = new int[n];
        r[0] = 1;
        if (n > 1) {
            int[] w = row(n - 1);
            for (int i = 1; i < n - 1; i++) {
                r[i] = w[i - 1] + w[i];
            }
            r[n - 1] = 1;
        }
        return r;
    }

}
