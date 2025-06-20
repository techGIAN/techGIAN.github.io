import java.util.Scanner;
import java.util.Stack;

public class Browser {
    public static final String IGNORED = "Ignored";
    public static Stack<String> forward_stack = new Stack<>();
    public static Stack<String> backward_stack = new Stack<>();
    public static String current_page = "http://www.acm.org";

    public static void doBack() {
        if (!backward_stack.empty()) {
            forward_stack.push(current_page);
            current_page = backward_stack.pop();
            System.out.println(current_page);
        } else {
            System.out.println(IGNORED);
        }
    }

    public static void doForward() {
        if (!forward_stack.empty()) {
            backward_stack.push(current_page);
            current_page = forward_stack.pop();
            System.out.println(current_page);
        } else {
            System.out.println(IGNORED);
        }
    }

    public static void doVisit(String url) {
        backward_stack.push(current_page);
        current_page = url;
        System.out.println(current_page);
        forward_stack.clear();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String cmd = scan.nextLine();
            if (cmd.equals("BACK")) {
                doBack();
            } else if (cmd.equals("FORWARD")) {
                doForward();
            } else if (cmd.startsWith("VISIT")) {
                doVisit(cmd.substring(6));
            } else if (cmd.equals("QUIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        scan.close();
    }
}
