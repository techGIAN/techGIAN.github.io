import java.util.*;

public class BellmanFordNegativeCycle {

    // Returns a sample graph as a set of edges (from, to, weight)
    public static Set<int[]> sampleGraph() {
        Set<int[]> edges = new HashSet<>();
        edges.add(new int[]{0, 1, 15});
        edges.add(new int[]{1, 2, -8});
        edges.add(new int[]{2, 0, -6});
        edges.add(new int[]{1, 6, 12});
        edges.add(new int[]{1, 3, 1});
        edges.add(new int[]{2, 4, 5});
        edges.add(new int[]{2, 7, -2});
        edges.add(new int[]{3, 4, 6});
        edges.add(new int[]{4, 5, 3});
        edges.add(new int[]{5, 3, -10});
        edges.add(new int[]{5, 6, 13});
        edges.add(new int[]{5, 7, 16});
        return edges;
    }

    // Returns the node set from the set of edges
    public static Set<Integer> getNodeSet(Set<int[]> graph) {
        Set<Integer> nodes = new HashSet<>();
        for (int[] edge : graph) {
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        return nodes;
    }

    // Applies Bellman-Ford algorithm on the graph
    public static Map<Integer, Double> bellmanFord(Set<int[]> graph) {
        Set<Integer> nodes = getNodeSet(graph);
        Map<Integer, Double> distance = new HashMap<>();

        // Initialize all distances to infinity
        for (int node : nodes) {
            distance.put(node, Double.POSITIVE_INFINITY);
        }

        int source = 0;
        distance.put(source, 0.0);

        // Relax all edges |V| - 1 times
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int[] edge : graph) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if (distance.get(from) + weight < distance.get(to)) {
                    distance.put(to, distance.get(from) + weight);
                }
            }
        }

        // Check for negative-weight cycles
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int[] edge : graph) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if (distance.get(from) + weight < distance.get(to)) {
                    distance.put(to, Double.NEGATIVE_INFINITY);
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Set<int[]> graph = sampleGraph();
        Map<Integer, Double> result = bellmanFord(graph);

        for (int node : result.keySet()) {
            System.out.println("Node " + node + ": " + result.get(node));
        }
    }
}