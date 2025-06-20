import java.util.*;

public class SSSPDijkstra {

    // Returns an edge weight map representation of a sample weighted and undirected graph
    public static Map<List<Integer>, Integer> sampleWeightedGraph() {
        Map<List<Integer>, Integer> G = new HashMap<>();
        G.put(Arrays.asList(0, 1), 4);
        G.put(Arrays.asList(0, 2), 8);
        G.put(Arrays.asList(1, 4), 6);
        G.put(Arrays.asList(2, 3), 2);
        G.put(Arrays.asList(4, 3), 10);
        return G;
    }

    // Returns neighbors of node x in graph G
    public static Set<Integer> getNeighbors(Map<List<Integer>, Integer> G, int x) {
        Set<Integer> neighbors = new HashSet<>();
        for (List<Integer> edge : G.keySet()) {
            if (edge.get(0) == x) {
                neighbors.add(edge.get(1));
            } else if (edge.get(1) == x) {
                neighbors.add(edge.get(0));
            }
        }
        return neighbors;
    }

    // Applies Dijkstra's Algorithm on weighted undirected graph G from source node s
    public static Map<Integer, Integer> dijkstra(Map<List<Integer>, Integer> G, int s) {
        Set<Integer> nodes = new HashSet<>();

        // Get the node set N
        for (List<Integer> edge : G.keySet()) {
            nodes.add(edge.get(0));
            nodes.add(edge.get(1));
        }

        // Initialize shortest distances from source node s
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node : nodes) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(s, 0);

        // Priority queue for node distances (min-heap based on distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, s});
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];

            if (visited.contains(u)) continue;
            visited.add(u);

            for (int v : getNeighbors(G, u)) {
                if (visited.contains(v)) continue;

                // Get weight (undirected, so check both orders)
                int w1 = G.getOrDefault(Arrays.asList(u, v), -1);
                int w2 = G.getOrDefault(Arrays.asList(v, u), -1);
                int weight = Math.max(w1, w2);

                if (dist.get(u) + weight < dist.get(v)) {
                    dist.put(v, dist.get(u) + weight);
                    pq.add(new int[]{dist.get(v), v});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Map<List<Integer>, Integer> G = sampleWeightedGraph();
        int source = 0;
        Map<Integer, Integer> result = dijkstra(G, source);

        // Print shortest distances from source node
        for (int node : result.keySet()) {
            System.out.println("Distance from " + source + " to " + node + " is " + result.get(node));
        }
    }
}