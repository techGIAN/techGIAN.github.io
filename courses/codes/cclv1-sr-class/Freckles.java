import java.util.*;

public class Freckles {

    public static Point[] POINTS;
    public static Double[][] CACHED_DISTANCES;

    public static List<Integer> readPoints(Scanner s) {
        s.nextLine();
        int n = Integer.parseInt(s.nextLine());

        POINTS = new Point[n];
        CACHED_DISTANCES = new Double[n][n];
        List<Integer> r = new LinkedList<>();
        for (int j = 0; j < n; ++j) {
            POINTS[j] = new Point(s.nextDouble(), s.nextDouble());
            r.add(j);
        }
        return r;
    }

    public static double distance(int p1, int p2) {
        int from = Math.min(p1, p2);
        int to = Math.max(p1, p2);
        if (CACHED_DISTANCES[from][to] == null) {
            CACHED_DISTANCES[from][to]= Math.sqrt((POINTS[p1].x - POINTS[p2].x) * (POINTS[p1].x - POINTS[p2].x) +
                                                  (POINTS[p1].y - POINTS[p2].y) * (POINTS[p1].y - POINTS[p2].y));
        }
        return CACHED_DISTANCES[from][to];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < M; ++i) {
            List<Integer> V = readPoints(scan);
            double total = 0;
            Set<Integer> S = new HashSet<>(Arrays.asList(V.remove(0)));

            while (!V.isEmpty()) {
                double min_dist = Double.MAX_VALUE;
                Integer min_node = null;
                for (int u: S) {
                    for (int v: V) {
                        double d = distance(u, v);
                        if (d < min_dist) {
                            min_dist = d;
                            min_node = v;
                        }
                    }
                }
                V.remove(min_node);
                S.add(min_node);
                total += min_dist;
            }
            System.out.printf("%.2f\n", total);
        }
        scan.close();
    }
}
