import java.util.*;

public class SSSP {
	
	public static Map<String, Integer> dijkstra(Map<String, List<String>> A, Map<String, Map<String, Integer>> W, String s) {
        Map<String, Integer> dist = new HashMap<>();
        dist.put(s, 0);
        for (String v : A.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
        }
        dist.put(s, 0);
        Set<String> S = new HashSet<>();
        List<String> Q = new ArrayList<>(A.keySet());

        while (!Q.isEmpty()) {

            int min_val = Integer.MAX_VALUE;
            String u = null;
            for (String node : Q) {
                if (dist.get(node) < min_val) {
                    min_val = dist.get(node);
                    u = node;
                }
            }

            Q.remove(u);
            S.add(u);

            for (String v : A.get(u)) {
                if (S.contains(v)) {
                    continue;
                }
                int weight = W.get(u).getOrDefault(v, Integer.MAX_VALUE);
                if (dist.get(v) > dist.get(u) + weight) {
                    dist.put(v, dist.get(u) + weight);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int P = scanner.nextInt();
        Map<String, List<String>> G = new HashMap<>();
        Map<String, Map<String, Integer>> W = new HashMap<>();
        Set<String> nodes = new HashSet<>();

        for (int i = 0; i < P; i++) {
            String s = scanner.next();
            String d = scanner.next();
            int c = scanner.nextInt();

            nodes.add(s);
            nodes.add(d);
            if (!G.containsKey(s)) {
                G.put(s, new ArrayList<>());
            }
            G.get(s).add(d);
            if (!W.containsKey(s)) {
                W.put(s, new HashMap<>());
            }
            W.get(s).put(d, c);
        }

        String home = scanner.next();
        String dest = scanner.next();

        Map<String, Integer> sssp = dijkstra(G, W, home);
        System.out.println(sssp.get(dest));
    }
}
