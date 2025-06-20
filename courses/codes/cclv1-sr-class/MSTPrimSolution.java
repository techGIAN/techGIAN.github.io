import java.io.*;
import java.util.*;

public class MSTPrimSolution {

	public static void main(String[] args) {
		
		ex2();
    }

	
	
	private static void ex2() {
		Scanner sc = new Scanner(System.in);
		Map<String[], Integer> W = new HashMap<>();
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] arr = sc.nextLine().split(" ");
			Integer w = Integer.parseInt(arr[2]);
			String[] edge = {arr[0], arr[1]};
			W.put(edge, w);
		}
		W = orderedPairs(W);
		Map<String, List<String>> G = getGraphFromWeights(W);
		Set<String[]> MSTEdges = prim(G, W);

        System.out.println("Minimum Spanning Tree Edges:");
        for (String[] edge : MSTEdges) {
            System.out.println(Arrays.toString(edge));
        }

        sc.close();
	}

	private static Set<String[]> prim(Map<String, List<String>> G, Map<String[], Integer> W) {
	    Set<String> TNodes = new HashSet<>();
	    Set<String[]> TEdges = new HashSet<>();
	    Map<String, Boolean> visited = new HashMap<>();
	    for (String node : G.keySet()) {
	        visited.put(node, false);
	    }

	    List<String> nodes = new ArrayList<>(G.keySet());
	    String s = nodes.get(0);
	    TNodes.add(s);
	    visited.put(s, true);

	    while (TEdges.size() < G.size() - 1) {
	        Set<String> connectedNodes = new HashSet<>();
	        Set<String[]> connectedEdges = new HashSet<>();
	        for (String node : TNodes) {
	            List<String> nbrs = G.get(node);
	            for (String nbr : nbrs) {
	                if (!visited.get(nbr)) {
	                    connectedNodes.add(nbr);
	                }
	            }
	        }
	        
	        for (String n1 : TNodes) {
	            for (String n2 : connectedNodes) {
	                String[] key = new String[2];
	                if (n1.compareTo(n2) > 0) {
	                		key[0] = n2;
	                		key[1] = n1;
		            } else {
		            		key[0] = n1;
		            		key[1] = n2;
		            }
	                
	                for (String[] k : W.keySet()) {
	                		if (k[0].equals(key[0]) && k[1].equals(key[1])) {
	                			connectedEdges.add(key);
	                			break;
	                		}
	                }
	            }
	        }

	        int minWeight = Integer.MAX_VALUE;
	        String[] minEdge = {null, null};
	        for (String[] edge : connectedEdges) {
	        		String[] kEdge = new String[2];
	        		Integer vWeight = 0;
	        		for (Map.Entry<String[],Integer> entry : W.entrySet())   {
	            		String[] myEdge = entry.getKey();
	            		boolean b1 = edge[0].equals(myEdge[0]);
	            		boolean b2 = edge[1].equals(myEdge[1]);
	            		if (b1 && b2) {
	            			kEdge[0] = myEdge[0];
	            			kEdge[1] = myEdge[1];
	            			vWeight = entry.getValue();
	            			break;
	            		}
	            }
	        		if (vWeight < minWeight) {
	        			minWeight = vWeight;
	        			minEdge[0] = kEdge[0];
	        			minEdge[1] = kEdge[1];
	        		}
	        }
	     

	        String e1 = minEdge[0];
            String e2 = minEdge[1];
            visited.put(e1, true);
            visited.put(e2, true);
            
            TEdges.add(minEdge);
            TNodes.add(e1);
            TNodes.add(e2);
	    }

	    return TEdges;
	}


	// Anything below this are helper functions only
	// DO NOT modify!

    private static Map<String[], Integer> orderedPairs(Map<String[], Integer> W) {
        Map<String[], Integer> orderedWeights = new HashMap<>();
        for (String[] k : W.keySet()) {
        		String[] newKey = new String[2];
            if (k[0].compareTo(k[1]) > 0) {
            		newKey[0] = k[1];
            		newKey[1] = k[0];
            		orderedWeights.put(newKey, W.get(k));
            }
            orderedWeights.put(k, W.get(k));
        }
        return orderedWeights;
    }


    
    private static Map<String, List<String>> getGraphFromWeights(Map<String[], Integer> W) {
   		Map<String, List<String>> G = new HashMap<>();
        for (Map.Entry<String[], Integer> entry : W.entrySet()) {
        		String e1 = entry.getKey()[0];
        		String e2 = entry.getKey()[1];
        		Integer weight = entry.getValue();
        		if (!G.containsKey(e1)) {
        			List<String> L1 = new ArrayList<>();
        			G.put(e1, L1);
        		}
        		List<String> l1 = G.get(e1);
        		l1.add(e2);
        		Set<String> s1 = new HashSet<>(l1);
        		l1 = new ArrayList<>(s1);
        		G.put(e1, l1);
        		if (!G.containsKey(e2)) {
        			List<String> L2 = new ArrayList<>();
        			G.put(e2, L2);
        		}
        		List<String> l2 = G.get(e2);
        		l2.add(e1);
        		Set<String> s2 = new HashSet<>(l2);
        		l2 = new ArrayList<>(s2);
        		G.put(e2, l2);
        }
        return G;
    }
    
   
}
