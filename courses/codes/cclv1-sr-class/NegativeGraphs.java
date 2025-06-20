import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;

public class NegativeGraphs {

	// DO NOT MODIFY!
	// create a class called Pair to handle ordered pairs
	public static class Pair<X, Y> {
        public final X x;
        public final Y y;
        
        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
        
        public void print() {
            System.out.print( "(" + this.x + ", " + this.y + ")" );
        }
        
        public void print(String s) {
            System.out.println( "(" + this.x + ", " + this.y + ")" );
        }
        
        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) other;
            return x.equals(pair.x) && y.equals(pair.y);
        }

        @Override
        public int hashCode() {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }
    }
	
	// DO NOT MODIFY!
	// given a map of edge to edge weights, return a list of nodes
	public static List<Object> getNodeList(Map<Pair<Object, Object>, Integer> weights) {
		Set<Pair<Object, Object>> edgeSet = weights.keySet();
		Set<Object> nodeSet = new HashSet<>();
		for (Pair<Object, Object> edge : edgeSet) {
			nodeSet.add(edge.x);
			nodeSet.add(edge.y);
		}
		List<Object> nodeList = new ArrayList<>();
		nodeList.addAll(nodeSet);
		return nodeList;
	}
	
	// DO NOT MODIFY!
	// given a map of edge to edge weights, return a list of edges
	public static List<Pair<Object, Object>> getEdgeList(Map<Pair<Object, Object>, Integer> weights) {
		List<Pair<Object, Object>> edgeList = new ArrayList<>();
		edgeList.addAll(weights.keySet());
		return edgeList;
	}
	
	// DO NOT MODIFY!
	// read a file path of the weights, then return a map with keys as edges (Pair) and values as weights (Integer)
	public static Map<Pair<Object, Object>, Integer> readWeightsFromFile(String filePath) {
        Map<Pair<Object, Object>, Integer> weights = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split(" ");
                Pair<Object, Object> edge = new Pair<>(arr[0], arr[1]);
                weights.put(edge, Integer.parseInt(arr[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return weights;
    }
	
	// DO NOT MODIFY!
	// simulates x + y and avoids overflows especially when arguments are infinity
	public static Integer addXY(Integer x, Integer y) {
		if (x == Integer.MAX_VALUE || y == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return x + y;
		}
	}
	
	
	// DO NOT MODIFY!
	// Reads a filePath and creates a graph; ensure that your filepath is correct
	// Either write your graph in this method directly, or have a file that reads your weighted graph
	// It should return a map of keys as edges (Pair) and values as weights (Integer)
	// Note: Edges are type Pair - it has x and y, which can be modelled as from and to respectively
	public static Map<Pair<Object, Object>, Integer> createGraph(String weightsFile) {
		Map<Pair<Object, Object>, Integer> w = new HashMap<>();
		w = readWeightsFromFile(weightsFile);
		return w;
	}
	
	// Modify this code depending on your graph (no need to modify if you are using a file)
	// It should return a map of keys as edges (Pair) and values as weights (Integer)
	// Note: Edges are type Pair - it has x and y, which can be modelled as from and to respectively
	public static Map<Pair<Object, Object>, Integer> createGraph() {
		Map<Pair<Object, Object>, Integer> w = new HashMap<>();
		
		// either do this
		w.put(new Pair<>('S', 'A'), 3);
		w.put(new Pair<>('S', 'B'), 14);
		w.put(new Pair<>('A', 'B'), 5);
		// then you still have to type in for the other edges/edge weights... 
		
		return w;
		
	}
	
	
	// Implement this code!
	// Given a src node and map with keys as edges (Pair) and values as weights (Integer), output the map with
	// keys as nodes (Object) and values as cheapest distance (Integer)
	public static Map<Object, Integer> bellmanFord(Map<Pair<Object, Object>, Integer> weights, Object src) {
		
		// initialization
		List<Object> nodeList = getNodeList(weights);
		List<Pair<Object, Object>> edgeList = getEdgeList(weights);
		
		Map<Object, Integer> dist = new HashMap<>();
		for (Object node : nodeList) {
			dist.put(node, Integer.MAX_VALUE);
		}
		dist.put(src, 0);
		
		// first round of relaxation: relax edges |N| - 1 times
		// to approximate distances
		for (int i = 0; i < nodeList.size()-1; i++) {
			for (Pair<Object, Object> edge : edgeList) {
				Object nodeFrom = edge.x;
				Object nodeTo = edge.y;
				dist.put(nodeTo, Math.min(addXY(dist.get(nodeFrom), weights.get(edge)), dist.get(nodeTo)));
			}
		}
		
		// second round of relaxation: relax edges |N| - 1 times
		// to catch nodes in negative cycles OR nodes reachable from negative cycles
		for (int i = 0; i < nodeList.size()-1; i++) {
			for (Pair<Object, Object> edge : edgeList) {
				Object nodeFrom = edge.x;
				Object nodeTo = edge.y;
				if (addXY(dist.get(nodeFrom), weights.get(edge)) < dist.get(nodeTo)) {
					dist.put(nodeTo, Integer.MIN_VALUE);
				}
			}
		}
		
		return dist;
		
	}
	

	
	public static void q2() {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int M = Integer.parseInt(sc.nextLine());
		Map<Pair<Object, Object>, Integer> timeFactors = new HashMap<>();
		for (int i = 0; i < M; i++) {
			String[] arr = sc.nextLine().split(" ");
			Pair<Object, Object> diRoad = new Pair<>(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			timeFactors.put(diRoad, Integer.parseInt(arr[2]));
		}
		
		String[] sd = sc.nextLine().split(" ");
		int s = Integer.parseInt(sd[0]);
		int d = Integer.parseInt(sd[1]);
		
		Map<Object, Integer> dist = bellmanFord(timeFactors, s);
		System.out.println(dist.get(d));
		
		sc.close();
	}
	
	public static void q2(String filePath) {
		try (Scanner sc = new Scanner(new File(filePath))) {
			int N = Integer.parseInt(sc.nextLine());
			int M = Integer.parseInt(sc.nextLine());
			
			Map<Pair<Object, Object>, Integer> timeFactors = new HashMap<>();
            for (int i = 0; i < M; i++) {
                String[] arr = sc.nextLine().split(" ");
                Pair<Object, Object> edge = new Pair<>(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                timeFactors.put(edge, Integer.parseInt(arr[2]));
            }
            
            String[] sd = sc.nextLine().split(" ");
    		int s = Integer.parseInt(sd[0]);
    		int d = Integer.parseInt(sd[1]);
	    		
    		Map<Object, Integer> dist = bellmanFord(timeFactors, s);
    		System.out.println(dist.get(d));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) {

		String inQ2 = "inputTextQ2.txt";
//		q2(inQ2);
	}
	
	// Not needed
	// Was only used for debugging and checking the values of dist
//	public static void prettyPrintDist(Map<Object, Integer> dist) {
//		for (Map.Entry<Object, Integer> e : dist.entrySet()) {
//			System.out.println("Node " + e.getKey() + ": " + e.getValue());
//		}
//		System.out.println("=====");
//	}

}
