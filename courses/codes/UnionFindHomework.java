import java.util.*;

class UnionFindHomework {
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
    
    

    public static void ex2() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        List<int[]> log = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" ");
            log.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])});
        }

        Collections.sort(log, Comparator.comparingInt(x -> x[2]));

        UnionFind uf = new UnionFind();
        for (int[] entry : log) {
            uf.make(String.valueOf(entry[0]));
            uf.make(String.valueOf(entry[1]));
            uf.union(String.valueOf(entry[0]), String.valueOf(entry[1]));

            if (allValuesEqual(uf.R) && containsAllFrom1ToN(uf.R, N)) {
                System.out.println(entry[2]);
                return;
            }
        }

        System.out.println("-1");
    }

    public static void main(String[] args) {

         ex2();
    }
}
