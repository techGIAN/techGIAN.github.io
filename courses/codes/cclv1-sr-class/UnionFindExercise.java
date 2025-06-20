import java.util.*;

class UnionFind {
    Map<String, String> R;

    public UnionFind() {
        this.R = new HashMap<>();
    }

    public void make(String x) {
        if (!R.containsKey(x)) {
            R.put(x, x);
        }
    }

    public String find(String x) {
        while (!x.equals(R.get(x))) {
            x = R.get(x);
        }
        return x;
    }

    public void union(String x, String y) {
        String rx = find(x);
        String ry = find(y);
        if (!rx.equals(ry)) {
            for (Map.Entry<String, String> entry : R.entrySet()) {
                if (entry.getValue().equals(ry)) {
                    entry.setValue(rx);
                }
            }
        }
    }
}

public class UnionFindExercise {

    public static void ex1() {
        Scanner scanner = new Scanner(System.in);
        List<String[]> friends = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            if (split.length == 1) {
                break;
            }
            friends.add(split);
        }

        String[] q = friends.remove(friends.size() - 1);

        UnionFind uf = new UnionFind();
        for (String[] pair : friends) {
            uf.make(pair[0]);
            uf.make(pair[1]);
            uf.union(pair[0], pair[1]);
        }

        System.out.println(uf.find(q[0]).equals(uf.find(q[1])) ? "yes" : "no");
    }

    public static boolean allValuesEqual(Map<String, String> R) {
        Set<String> values = new HashSet<>(R.values());
        return values.size() == 1;
    }
    
    public static boolean containsAllFrom1ToN(Map<String, String> m, int N) {
        for (int i = 1; i <= N; i++) {
        	String s = String.valueOf(i);
        	if (!m.containsKey(s))
        		return false;
        }
        return true;
    }
    
    

   

    public static void main(String[] args) {
        ex1();
    }
}
