import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class InClassEx3 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Map<String, Integer> names = new HashMap<>();

        for (int i = 0; i < N; ++i) {
            String n = scan.next();
            if (names.containsKey(n)) {
                names.put(n, names.get(n) + 1);
            } else {
                names.put(n, 1);
            }
        }

        Map<String, Integer> result = names.entrySet().stream()
                .sorted(Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        result.forEach((k, v) -> System.out.println(k + ", " + v));

        scan.close();
    }
}
