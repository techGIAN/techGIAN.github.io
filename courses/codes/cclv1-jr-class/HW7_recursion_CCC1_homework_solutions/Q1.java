import java.util.*;

public class Q1 {

    public static List<String> grow(List<String>s, int k) {
        if (k == 0) {
            return s;
        }
        List<String> r = new LinkedList<String>();
        for (String i: s) {
            r.add(i + "0");
            if (i.charAt(i.length() - 1) == '0') {
                r.add(i + "1");
            }
        }
        return grow(r, k-1);
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int d = scan.nextInt();
        List<String> zero = new LinkedList<String>();
        zero.add("0");
        List<String> zeroes = grow(zero, d-1);
        List<String> one = new LinkedList<String>();
        one.add("1");
        List<String> ones = grow(one, d-1);

        for (String a: zeroes) {
            System.out.println(a);
        }

        for (String a: ones) {
            System.out.println(a);
        }
        scan.close();
    }
}
