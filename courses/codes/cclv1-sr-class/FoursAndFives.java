import java.util.Scanner;

public class FoursAndFives {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ways = 0;

        for (int i = 0; i <= N / 5; i++) {
            if ((N - 5*i) % 4 == 0) {
                ways++;
            }
        }

        System.out.println(ways);
    }
}