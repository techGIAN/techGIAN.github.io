import java.util.*;

public class Prosjek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add((double) sc.nextInt());
        }

        while (pq.size() > 1) {
            double x1 = pq.poll();
            double x2 = pq.poll();
            double avg = (x1 + x2) / 2.0;
            pq.add(avg);
        }

        System.out.printf("%.6f\n", pq.peek());  // format with precision
    }
}