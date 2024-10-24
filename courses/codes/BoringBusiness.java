import java.util.*;

public class BoringBusiness {

    boolean[][] wellPlan = new boolean[401][200];
    int x = 200;    // -200 ... 200 is mapped to 0 ... 400
    int y = 199;    // -200 ... -1 is mapped to 0 ... 199
    boolean danger = false;

    public BoringBusiness() {
        // mark initial location
        wellPlan[this.x][this.y] = true;
    }

    public void drill(char direction, int steps) {
        for (int i = 0; i < steps; ++i) {
            if (direction == 'd') {
                this.y -= 1;
            } else if (direction == 'u') {
                this.y += 1;
            } else if (direction == 'l') {
                this.x -= 1;
            } else if (direction == 'r') {
                this.x += 1;
            } else {
                System.out.println("Invalid direction");
            }

            if (wellPlan[this.x][this.y]) {
                danger = true;
            } else {
                wellPlan[this.x][this.y] = true;
            }
        }
    }

    public void printWellPlan(int span_x, int span_y) {

        for (int j = 199; j > 199 - span_y; --j) {
            for (int i = 200 - span_x; i < 200 + span_x + 1; ++i) {
                System.out.print((wellPlan[i][j])? 'X': ' ');
            }
            System.out.println();
        }
    }

    public void printLocation() {
        System.out.print((this.x - 200) + ", " + (this.y - 200));
    }

    public static void main(String[] args) {

        BoringBusiness well = new BoringBusiness();

        // initial setup
        well.drill('d', 2);
        well.drill('r', 3);
        well.drill('d', 2);
        well.drill('r', 2);
        well.drill('u', 2);
        well.drill('r', 2);
        well.drill('d', 4);
        well.drill('l', 8);
        well.drill('u', 2);

        // well.printWellPlan(10, 10);

        Scanner scan = new Scanner(System.in);
        while (true) {
            // System.out.print("> ");
            String cmd = scan.next();
            int n = scan.nextInt();
            if (cmd.equals("q")) {
                break;
            } else {
                well.drill(cmd.charAt(0), n);
                // well.printWellPlan(10, 10);
                well.printLocation();
                System.out.println(" " + ((well.danger)? "DANGER": "safe"));
                if (well.danger) {
                    break;
                }
            }
        }
        scan.close();
    }
}
