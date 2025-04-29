import java.util.*;

public class MinimumSpanningTreeSample {

    // Returns a sample weighted undirected graph
    public static Map<List<Integer>, Integer> sampleWeightedGraph() {
        Map<List<Integer>, Integer> graph = new HashMap<>();
        graph.put(Arrays.asList(0, 1), 2);
        graph.put(Arrays.asList(0, 2), 8);
        graph.put(Arrays.asList(1, 4), 6);
        graph.put(Arrays.asList(2, 3), 2);
        graph.put(Arrays.asList(4, 3), 6);
        return graph;
    }

    // Returns the node set from a weighted graph
    public static Set<Integer> getNodeSet(Map<List<Integer>, Integer> graph) {
        Set<Integer> nodes = new HashSet<>();
        for (List<Integer> edge : graph.keySet()) {
            nodes.add(edge.get(0));
            nodes.add(edge.get(1));
        }
        return nodes;
    }

    // Returns the edge set
    public static Set<List<Integer>> getEdgeSet(Map<List<Integer>, Integer> graph) {
        return graph.keySet();
    }

    // Returns neighbors of a given node
    public static Set<Integer> getNeighbors(Map<List<Integer>, Integer> graph, int node) {
        Set<Integer> neighbors = new HashSet<>();
        for (List<Integer> edge : graph.keySet()) {
            if (edge.get(0) == node) {
                neighbors.add(edge.get(1));
            } else if (edge.get(1) == node) {
                neighbors.add(edge.get(0));
            }
        }
        return neighbors;
    }

    // Apply Prim's algorithm
    public static Set<List<Integer>> prim(Map<List<Integer>, Integer> graph) {
        Set<List<Integer>> tree = new HashSet<>();
        Set<Integer> treeNodes = new HashSet<>();
        Set<Integer> nodes = getNodeSet(graph);
        Set<List<Integer>> edges = getEdgeSet(graph);
        boolean[] visited = new boolean[nodes.size()];
        int startNode = 0;
        treeNodes.add(startNode);
        visited[startNode] = true;

        while (tree.size() < nodes.size() - 1) {
            Set<List<Integer>> candidateEdges = new HashSet<>();

            for (int node : treeNodes) {
                Set<Integer> neighbors = getNeighbors(graph, node);
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        int minNode = Math.min(node, neighbor);
                        int maxNode = Math.max(node, neighbor);
                        candidateEdges.add(Arrays.asList(minNode, maxNode));
                    }
                }
            }

            int minWeight = Integer.MAX_VALUE;
            List<Integer> minEdge = null;

            for (List<Integer> edge : candidateEdges) {
                List<Integer> orderedEdge = Arrays.asList(Math.min(edge.get(0), edge.get(1)), Math.max(edge.get(0), edge.get(1)));
                if (graph.containsKey(orderedEdge)) {
                    int weight = graph.get(orderedEdge);
                    if (weight < minWeight) {
                        minWeight = weight;
                        minEdge = orderedEdge;
                    }
                }
            }

            if (minEdge != null) {
                visited[minEdge.get(0)] = true;
                visited[minEdge.get(1)] = true;
                tree.add(minEdge);
                treeNodes.add(minEdge.get(0));
                treeNodes.add(minEdge.get(1));
            }
        }

        return tree;
    }

    // Apply Kruskal's algorithm
    public static Set<List<Integer>> kruskal(Map<List<Integer>, Integer> graph) {
        Set<Integer> nodes = getNodeSet(graph);
        Set<List<Integer>> edges = getEdgeSet(graph);

        // Sort edges by weight
        List<Map.Entry<List<Integer>, Integer>> sortedEdges = new ArrayList<>(graph.entrySet());
        sortedEdges.sort(Map.Entry.comparingByValue());

        Map<Integer, Integer> disjointSet = new HashMap<>();
        for (int node : nodes) {
            disjointSet.put(node, node); // make set
        }

        Set<List<Integer>> tree = new HashSet<>();

        for (Map.Entry<List<Integer>, Integer> entry : sortedEdges) {
            List<Integer> edge = entry.getKey();
            int n1 = edge.get(0);
            int n2 = edge.get(1);

            if (!disjointSet.get(n1).equals(disjointSet.get(n2))) {
                tree.add(edge);
                int oldRep = disjointSet.get(n2);
                int newRep = disjointSet.get(n1);

                // union sets
                for (int node : disjointSet.keySet()) {
                    if (disjointSet.get(node) == oldRep) {
                        disjointSet.put(node, newRep);
                    }
                }
            }
        }

        return tree;
    }

    public static void main(String[] args) {
        Map<List<Integer>, Integer> graph = sampleWeightedGraph();

        System.out.println("Prim's Algorithm:");
        Set<List<Integer>> primTree = prim(graph);
        for (List<Integer> edge : primTree) {
            System.out.println(edge);
        }

        System.out.println("\nKruskal's Algorithm:");
        Set<List<Integer>> kruskalTree = kruskal(graph);
        for (List<Integer> edge : kruskalTree) {
            System.out.println(edge);
        }
    }
}