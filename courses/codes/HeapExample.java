import java.util.List;
import java.util.ArrayList;

public class HeapExample {

    static List<Integer> H;

    public static void add(int x) {
        H.add(x);
        int idx = H.size() - 1;
        upheap(idx);
    }

    public static int peek() {
        return H.get(0);
    }

    public static int extractMin() {
        int minValue = peek();
        int last = H.get(H.size()-1);
        H.set(0, last);
        H.remove(H.size()-1);
        downheap(0);
        return minValue;
    }

    public static void upheap(int i) {
        int p = (i - 1) / 2;
        if (p == -1) return;
        if (H.get(p) > H.get(i)) {
            int temp = H.get(p);
            H.set(p, H.get(i));
            H.set(i, temp);
            upheap(p);
        }
    }

    public static void downheap(int i) {
        
        int lc = 2*i + 1;
        int rc = 2*i + 2;

        if (lc >= H.size()) return;
        else if (rc >= H.size()) {
            int temp = H.get(i);
            H.set(i, H.get(lc));
            H.set(lc, temp);
        } else {
            if (H.get(lc) <= H.get(rc)) {
                int temp = H.get(i);
                H.set(i, H.get(lc));
                H.set(lc, temp);
                downheap(lc);
            } else {
                int temp = H.get(i);
                H.set(i, H.get(rc));
                H.set(rc, temp);
                downheap(rc);
            }
        }
    }

    public static void main(String[] args) {
        H = new ArrayList<>();

        add(6);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(50);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(11);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(25);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(42);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(20);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(98);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(76);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(19);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(55);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(88);
        System.out.println("Min element: " + peek() + "; H = " + H);

        add(2);
        System.out.println("Min element: " + peek() + "; H = " + H);

        System.out.println(H);

        int minValue = extractMin();
        System.out.println("Min element: " + minValue + "; H = " + H);

        minValue = extractMin();
        System.out.println("Min element: " + minValue + "; H = " + H);

        minValue = extractMin();
        System.out.println("Min element: " + minValue + "; H = " + H);

    }

}