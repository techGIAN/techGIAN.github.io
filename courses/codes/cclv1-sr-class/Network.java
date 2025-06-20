import java.util.*;

public class Network {
    static List<Integer>[] graph;
    static List<Integer> order = new ArrayList<>();

    public static void traversal(int cur, int prev) {
        if (graph[cur].size() == 1) {
            order.add(cur);
        }
        for (int adj : graph[cur]) {
            if (adj == prev) {
                continue;
            }
            traversal(adj, cur);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        traversal(1, -1);
        int cnt = order.size();
        System.out.println((cnt + 1) / 2); // Number of pairs

        if (cnt % 2 == 1) {  // Odd case, pair with any other leaf
            System.out.println(order.get(0) + " " + order.get(cnt - 1));
            cnt--;
            order.remove(cnt);
        }

        int offset = cnt / 2;  // Match first half with second half
        for (int i = 0; i < cnt / 2; i++) {
            System.out.println(order.get(i) + " " + order.get(i + offset));
        }

        scanner.close();
    }
}