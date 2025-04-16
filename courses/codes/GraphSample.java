// GraphSample.java
// This code provides an example of a graph
// and how you can implement it in Java

import java.util.*;

public class GraphSample {

    // Returns an edge list representation of Graph Example 1
    // Each pair represents an edge
    // Order matters if the graph is directed (from, to)
    // Order doesn't matter if graph is undirected - avoid duplicates (a, b) by ensuring a < b
    public static List<String[]> edgeListEx1() {
        return Arrays.asList(
                new String[]{"A", "B"},
                new String[]{"A", "C"},
                new String[]{"B", "C"},
                new String[]{"A", "D"}
        );
    }

    // Returns an edge set representation of Graph Example 1
    // Caveat: cannot handle multi-graphs, but this is faster in code!
    // Each pair represents an edge
    // Order matters if the graph is directed (from, to)
    // Order doesn't matter if graph is undirected - avoid duplicates (a, b) by ensuring a < b
    public static Set<List<String>> edgeSetEx1() {
        Set<List<String>> edgeSet = new HashSet<>();
        edgeSet.add(Arrays.asList("A", "B"));
        edgeSet.add(Arrays.asList("A", "C"));
        edgeSet.add(Arrays.asList("B", "C"));
        edgeSet.add(Arrays.asList("A", "D"));
        return edgeSet;
    }

    // Returns an adjacency list representation of Graph Example 1 as a map
    // Keys: nodes
    // Values: neighbors of each node as a list
    public static Map<String, List<String>> adjListEx1() {
        Map<String, List<String>> adjList = new HashMap<>();
        adjList.put("A", Arrays.asList("B", "C", "D"));
        adjList.put("B", Arrays.asList("A", "C"));
        adjList.put("C", Arrays.asList("A", "B"));
        adjList.put("D", Arrays.asList("A"));
        return adjList;
    }

    // Returns an adjacency set representation of Graph Example 1 as a map
    // Keys: nodes
    // Values: neighbors of each node as a set
    // Faster and more natural as lists have an ordering that is captured which is not necessary
    // But this also means that lists can allow duplicates and sets do not, so multi-graphs are not possible
    public static Map<String, Set<String>> adjSetEx1() {
        Map<String, Set<String>> adjSet = new HashMap<>();
        adjSet.put("A", new HashSet<>(Arrays.asList("B", "C", "D")));
        adjSet.put("B", new HashSet<>(Arrays.asList("A", "C")));
        adjSet.put("C", new HashSet<>(Arrays.asList("A", "B")));
        adjSet.put("D", new HashSet<>(Collections.singletonList("A")));
        return adjSet;
    }

    // Returns an adjacency matrix representation of Graph Example 1 as a 2D array
    // 1 if there is an edge, 0 for no edge
    // Symmetric along the main diagonal if undirected; asymmetric if directed
    // All entries in the main diagonal are zeros if there are no self-loops in the graph
    // Advantage of this is that the nodes are generic, but you have to know the ordering yourself that it was 'A', 'B', ...
    public static int[][] adjMatrixEx1() {
        return new int[][]{
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0}
        };
    }

    // Returns an edge weight set representation of Graph Example 2
    // Keys: edges as pairs
    // Values: edge weights
    public static Map<List<String>, Integer> edgeSetEx2() {
        Map<List<String>, Integer> edgeWeights = new HashMap<>();
        edgeWeights.put(Arrays.asList("A", "B"), 3);
        edgeWeights.put(Arrays.asList("A", "C"), 2);
        edgeWeights.put(Arrays.asList("C", "B"), 1);
        edgeWeights.put(Arrays.asList("D", "A"), 4);
        return edgeWeights;
    }

    // Returns an adjacency nested representation of Graph Example 2
    public static Map<String, Map<String, Integer>> adjWeightMapEx2() {
        Map<String, Map<String, Integer>> adjWeight = new HashMap<>();

        Map<String, Integer> aEdges = new HashMap<>();
        aEdges.put("B", 3);
        aEdges.put("C", 2);
        adjWeight.put("A", aEdges);

        adjWeight.put("B", new HashMap<>());

        Map<String, Integer> cEdges = new HashMap<>();
        cEdges.put("B", 1);
        adjWeight.put("C", cEdges);

        Map<String, Integer> dEdges = new HashMap<>();
        dEdges.put("A", 4);
        adjWeight.put("D", dEdges);

        return adjWeight;
    }

    // Returns an adjacency matrix representation of Graph Example 2
    // Each entry A[i][j], where i is the from and j is the to
    // Each A[i][j] represents the edge weight
    public static int[][] adjMatrixEx2() {
        return new int[][]{
                {0, 3, 2, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {4, 0, 0, 0}
        };
    }

    public static void main(String[] args) {
        // Sample usage (optional)
    }
}
