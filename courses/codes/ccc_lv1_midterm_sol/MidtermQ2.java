import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MidtermQ2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int C = scanner.nextInt();  // capacity threshold
        int N = scanner.nextInt();  // number of balls expected to juggle
        List<Integer> weights = new ArrayList<>();  // weights of all the balls
        List<Integer> currBalls = new ArrayList<>();  // current balls that Charlie juggles
        int balls = 0;  // number of balls that can be juggled

        for (int i = 0; i < N; i++) {  // get user inputs for the weight of balls
            weights.add(scanner.nextInt());
        }

        for (int w : weights) {  // for each ball that has weight w

            if (w > C) {
                break;
            }

            currBalls.add(w);
            balls++;

            if (currBalls.size() > 4) {
                currBalls.remove(0);
            }

            int sum = 0;
            for (int ball : currBalls) {
                sum += ball;
            }

            if (sum > C) {
                balls--;
                break;
            }
        }

        System.out.println(balls);
    }
    
   
}
