import java.util.*;

public class Q2 {

    public static String bounce(int k) {
        if (k <= 0) {
            return String.valueOf(k);
        } else {
            return String.valueOf(k) + " " + bounce(k-5) + " " + String.valueOf(k);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println(bounce(scan.nextInt()));
        scan.close();
    }
}
