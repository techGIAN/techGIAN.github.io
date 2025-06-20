import java.util.*;

public class BoxTransforms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        List<int[]> keyPositions = new ArrayList<>();
        int target = b[0];
        int A_index = 0;
        int i = 0;

        while (i < n) {
            while (i < n && b[i] == target) {
                i++;
            }
            while (A_index < n && a[A_index] != target) {
                A_index++;
            }
            if (A_index >= n) {
                System.out.println("NO");
                return;
            }
            keyPositions.add(new int[]{target, A_index});
            if (i < n) {
                target = b[i];
            }
        }

        System.out.println("YES");

        List<int[]> loyalMoves = new ArrayList<>();
        int loyal = 0;
        target = b[0];
        int keyIndex = 0;
        i = 0;

        while (i < n && keyIndex < keyPositions.size()) {
            while (i < n && b[i] == target) {
                i++;
            }
            if (keyPositions.get(keyIndex)[1] > loyal) {
                loyalMoves.add(new int[]{loyal, keyPositions.get(keyIndex)[1]});
            }
            if (i < n) {
                target = b[i];
            }
            loyal = i;
            keyIndex++;
        }

        List<int[]> royalMoves = new ArrayList<>();
        int royal = n - 1;
        target = b[n - 1];
        keyIndex = keyPositions.size() - 1;
        i = n - 1;

        while (i >= 0 && keyIndex >= 0) {
            while (i >= 0 && b[i] == target) {
                i--;
            }
            if (keyPositions.get(keyIndex)[1] < royal) {
                royalMoves.add(new int[]{keyPositions.get(keyIndex)[1], royal});
            }
            if (i >= 0) {
                target = b[i];
            }
            royal = i;
            keyIndex--;
        }

        System.out.println(loyalMoves.size() + royalMoves.size());
        for (int[] move : loyalMoves) {
            System.out.println("L " + (move[0] + 1) + " " + (move[1] + 1));
        }
        for (int[] move : royalMoves) {
            System.out.println("R " + (move[0] + 1) + " " + (move[1] + 1));
        }
    }
}