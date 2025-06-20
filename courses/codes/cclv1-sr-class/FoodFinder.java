import java.util.*;
import java.lang.Math;

public class FoodFinder {
	
	// create a helper class called Pair to handle ordered pairs
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
            Pair<X, Y> pair = (Pair<X, Y>) other;
            return x.equals(pair.x) && y.equals(pair.y);
        }

        @Override
        public int hashCode() {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }
    }
	 
	public static boolean dfs(Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> G, List<Pair<Integer, Integer>> foodLocs, Integer C, Pair<Integer, Integer> destLoc) {
		Stack<Pair<Integer, Integer>> S = new Stack<>();
		Map<Pair<Integer, Integer>, Boolean> V = new HashMap<>();
		for (Pair<Integer, Integer> node : G.keySet()) {
			V.put(node, false);
		}
		
		int numOfFoodObtained = 0;
		boolean destReached = false;
		S.push(new Pair<>(0,0));
		
		while (!S.isEmpty()) {
			Pair<Integer, Integer> node = S.pop();
			if (!V.get(node)) {
				V.put(node, true);
				
				if (foodLocs.contains(node)) {
					numOfFoodObtained++;
				}
				if (node.equals(destLoc)) {
					destReached = true;
				}
				
				for (Pair<Integer, Integer> nbr : G.get(node)) {
					if (!V.get(nbr)) {
						S.push(nbr);
					}
				}
			}
			
		}
		
		return numOfFoodObtained >= C && destReached;
		
	}
	
    // helper function only ("cross product")
    // example input List: {(0,0), (1,1), (2,2)}
    // example output List: {((0,0), (1,1)), ((0,0), (2,2)), ((1,1), (2,2))}
	public static List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getPairList(List<Pair<Integer, Integer>> nodes) {
		List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> pairs = new ArrayList<>();
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = i; j < nodes.size(); j++) {
				Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair = new Pair<>(nodes.get(i), nodes.get(j));
				pairs.add(pair);
			}
		}
		return pairs;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.nextLine());	// amount of food required
		int m = Integer.parseInt(sc.nextLine());	// rows
		int n = Integer.parseInt(sc.nextLine());	// cols
		
		// locations with food
		List<Pair<Integer, Integer>> foodLoc = new ArrayList<>();
		
		// Create adj list
		Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> G = new HashMap<>();
		
		for (int i = 0; i < m; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				if (line.charAt(j) != 'X') {
					Pair<Integer, Integer> loc = new Pair<>(i, j);
					if (!G.containsKey(loc)) {
						G.put(loc, new ArrayList<>());
					}
					if (line.charAt(j) == 'F') {
						foodLoc.add(loc);
					}
				}
			}
		}
		
		List<Pair<Integer, Integer>> my_nodes = new ArrayList<>();
		my_nodes.addAll(G.keySet());
		
		for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> combo : getPairList(my_nodes)) {
			Pair<Integer, Integer> u = combo.x;
			Pair<Integer, Integer> v = combo.y;
			if (!u.equals(v)) {
				if ((v.x == u.x && Math.abs(v.y - u.y) == 1) || (v.y == u.y && Math.abs(v.x - u.x) == 1)) {
					List<Pair<Integer, Integer>> nbrs = G.get(u);
					nbrs.add(v);
					G.put(u, nbrs);
					
					nbrs = G.get(v);
					nbrs.add(u);
					G.put(v, nbrs);
				}
			}
		}
		
		Pair<Integer, Integer> dest = new Pair<>(m-1, n-1);
		char output = dfs(G, foodLoc, C, dest) ? 'Y' : 'N';
		System.out.println(output);
		
		sc.close();
	}


}