import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1 {
    /**
     * Builds a tree
     * @param m: number of edges
     * @param scan: scanner object
     * @return tree
     */
    public static Map<Integer, Set<Integer>> buildTree(int m, Scanner scan) {
        Map<Integer, Set<Integer>> t = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (t.get(a) != null) {
                t.get(a).add(b);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(b);
                t.put(a, s);
            }
        }
        return t;
    }

    /**
     * BFS the tree t, starting from value p, for value q.
     * @param n: nodes are from 1 to n
     * @param t: the tree
     * @param p: source value
     * @param q: target value
     * @return true if q is reachable from p.  false if it is not.
     */
    public static boolean searchTree(Map<Integer, Set<Integer>> t, int p, int q) {
        Set<Integer> discovered = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            if (u == q) {
                return true;
            }
            if (t.containsKey(u)) {
                for (int v: t.get(u)) {
                    if (!discovered.contains(v)) {
                        discovered.add(v);
                        queue.add(v);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        Map<Integer, Set<Integer>> myTree = buildTree(M, scan);
        int P = scan.nextInt();
        int Q = scan.nextInt();
        if (searchTree(myTree, P, Q)) {
            System.out.println("yes");
        } else if (searchTree(myTree, Q, P)) {
            System.out.println("no");
        } else {
            System.out.println("unknown");
        }
        scan.close();
    }
}
