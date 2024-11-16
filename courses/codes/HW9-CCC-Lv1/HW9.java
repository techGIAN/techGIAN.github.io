import java.util.Stack;
import java.util.Scanner;

public class HW9 {

    public static boolean recipeCompleted(int N, Scanner scan) {
        Stack<Integer> mountain_top = new Stack<Integer>();
        Stack<Integer> branch = new Stack<Integer>();

        for (int j = 0; j < N; ++j) {
            mountain_top.push(scan.nextInt());
        }

        int n = 1;
        while (n < N) {
            // only need to verify cars #1, 2, ... N-1
            if (!mountain_top.empty() && mountain_top.peek() == n) {
                mountain_top.pop();
                ++n;
            } else if (!branch.empty() && branch.peek() == n) {
                branch.pop();
                ++n;
            } else if (!mountain_top.empty()) {
                branch.push(mountain_top.pop());
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; ++i) {
            int N = scan.nextInt();
            System.out.println(recipeCompleted(N, scan)? "Y" : "N");
        }
        scan.close();
    }
}
