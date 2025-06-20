
import java.util.*;

public class GraphSearchSample {

    // Creates the adjacency set representation of a sample graph
    public static Map<Integer, Set<Integer>> sampleGraph() {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        graph.put(0, new HashSet<>(Arrays.asList(1, 2)));
        graph.put(1, new HashSet<>(Arrays.asList(1, 2)));
        graph.put(2, new HashSet<>(Arrays.asList(0, 1, 3, 4)));
        graph.put(3, new HashSet<>(Arrays.asList(2)));
        graph.put(4, new HashSet<>(Arrays.asList(2)));

        return graph;
    }

    // Returns the node set N given the adjacency list G
    public static Set<Integer> getNodeSet(Map<Integer, Set<Integer>> G) {
        return G.keySet();
    }

    // Returns the edge set E given the adjacency list G
    public static Set<String> getEdgeSet(Map<Integer, Set<Integer>> G, boolean directed) {
        Set<String> edges = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : G.entrySet()) {
            int from = entry.getKey();
            for (int to : entry.getValue()) {
                if (directed || from < to) {
                    edges.add(from + "," + to);
                }
            }
        }
        return edges;
    }

    // Apply the BFS Algorithm on graph G
    public static void bfs(Map<Integer, Set<Integer>> G) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> nodes = getNodeSet(G);
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Integer> level = new HashMap<>();

        for (int node : nodes) {
            visited.put(node, false);
            level.put(node, Integer.MAX_VALUE);
        }

        int source = 0;
        queue.add(source);
        visited.put(source, true);
        level.put(source, 0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Level {" + level.get(node) + "}: {" + node + "}");

            for (int neighbor : G.get(node)) {
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                    level.put(neighbor, level.get(node) + 1);
                }
            }
        }
    }

    // Apply the DFS Algorithm on graph G
    public static void dfs(Map<Integer, Set<Integer>> G) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> nodes = getNodeSet(G);
        Map<Integer, Boolean> visited = new HashMap<>();

        for (int node : nodes) {
            visited.put(node, false);
        }

        int source = 0;
        stack.push(source);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.get(node)) {
                visited.put(node, true);
                System.out.println("Visited node {" + node + "}");
                for (int neighbor : G.get(node)) {
                    if (!visited.get(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> G = sampleGraph();

        System.out.println("BFS: ");
        bfs(G);

        System.out.println("DFS: ");
        dfs(G);
    }
}