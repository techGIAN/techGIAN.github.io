import java.util.*;

public class HW6Q1 {
    final static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static String lastSyllable(String word) {
        for (int i = word.length() - 1; i >= 0; --i) {
            if (VOWELS.contains(word.charAt(i))) {
                return word.substring(i).toLowerCase();
            }
        }
        return word.toLowerCase();
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; ++i) {
            String[] poem = new String[4];
            for (int j = 0; j < 4; ++j) {
            	String[] line = scan.nextLine().split(" ");
                poem[j] = lastSyllable(line[line.length-1]);
            }
            boolean s0s1 = poem[0].equals(poem[1]);
            boolean s0s2 = poem[0].equals(poem[2]);
            boolean s0s3 = poem[0].equals(poem[3]);
            boolean s1s2 = poem[1].equals(poem[2]);
            boolean s1s3 = poem[1].equals(poem[3]);
            boolean s2s3 = poem[2].equals(poem[3]);

            if (s0s1 && s0s2 && s0s3) {
                System.out.println("perfect");
            } else if (s0s1 && s2s3) {
                System.out.println("even");
            } else if (s0s2 && s1s3) {
                System.out.println("cross");
            } else if (s0s3 && s1s2) {
                System.out.println("shell");
            } else {
                System.out.println("free");
            }
        }
        scan.close();
    }
}
