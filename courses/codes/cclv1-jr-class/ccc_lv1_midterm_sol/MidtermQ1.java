import java.util.HashMap;
import java.util.Scanner;

public class MidtermQ1 {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // number of cookie types
        int N = scanner.nextInt(); // the number of students

        HashMap<Integer, Character> cookieSize = new HashMap<>(); // keys are the cookie type, values are cookie size

        for (int i = 1; i <= M; i++) {
            cookieSize.put(i, scanner.next().charAt(0)); // each value will be a char 'S', 'M', or 'L'
        }

        // which cookie sizes will satisfy a student given their preferred size
        HashMap<Character, char[]> satisfiableSize = new HashMap<>();
        satisfiableSize.put('L', new char[]{'L'});
        satisfiableSize.put('M', new char[]{'M', 'L'});
        satisfiableSize.put('S', new char[]{'S', 'M', 'L'});

        int thumbsUp = 0; // how many students will give a thumbs up

        for (int j = 1; j <= N; j++) {
            char preferredSize = scanner.next().charAt(0);
            int preferredType = scanner.nextInt();

            if (!cookieSize.containsKey(preferredType)) { // can't satisfy student if it is not preferred type
                continue; // move on to the next student
            }

            char size = cookieSize.get(preferredType); // get the size of the preferred_type

            if (new String(satisfiableSize.get(preferredSize)).contains(String.valueOf(size))) {
                thumbsUp++;
                cookieSize.remove(preferredType); // make sure to remove cookie as no other student can get it anymore
            }
        }

        System.out.println(thumbsUp);
    }
    
   
}
