import java.util.Scanner;
import java.util.Map;
import static java.util.Map.entry;

public class HW15 {

    public static Map<Character, Double> prob_table = Map.ofEntries(
        entry('A', 0.082), entry('B', 0.015), entry('C', 0.028), entry('D', 0.043),
        entry('E', 0.127), entry('F', 0.022), entry('G', 0.020), entry('H', 0.061),
        entry('I', 0.070), entry('J', 0.002), entry('K', 0.008), entry('L', 0.040),
        entry('M', 0.024), entry('N', 0.067), entry('O', 0.075), entry('P', 0.019),
        entry('Q', 0.001), entry('R', 0.060), entry('S', 0.063), entry('T', 0.091),
        entry('U', 0.028), entry('V', 0.010), entry('W', 0.023), entry('X', 0.001),
        entry('Y', 0.020), entry('Z', 0.001));

    /**
     * Return probability of cipher text shifted by s characters
     * @param ct: the ciphertext
     * @param s: the shift amount
     * @return: the probability
     */
    public static double calc_probability(String ct, int s) {

        double r = 1;
        for (int i = 0; i < ct.length(); ++i) {
            if (ct.charAt(i) != ' ') {
                r *= prob_table.get(shift_char(ct.charAt(i), s));
            }
        }
        return r;
    }

    /**
     *  Shifts character c by s positions.  Wraps around to 'A' after 'Z'
     *  @param c: the character
     *  @param s: the shift amount
     *  @return: the shifted characters
     */
    public static char shift_char(char c, int s) {
        int chr_ord = (int) c + s;
        if (chr_ord > 'Z') {
            chr_ord -= 26;
        }
        return (char) chr_ord;
    }


    public static void print_cipher_text(String ct, int k) {
        for (int i = 0; i < ct.length(); ++i) {
            System.out.print(ct.charAt(i) == ' '? ' ': shift_char(ct.charAt(i), k));
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int num_cases = Integer.parseInt(scan.nextLine());
        for (int n = 0; n < num_cases; ++n) {
            String ciphertext = scan.nextLine();
            double max_p = 0;
            int max_k = 0;
            for (int k = 0; k < 26; ++k) {
                double p = calc_probability(ciphertext, k);
                if (max_p < p) {
                    max_p = p;
                    max_k = k;
                }
            }
            print_cipher_text(ciphertext, max_k);
        }
        scan.close();
    }
}
