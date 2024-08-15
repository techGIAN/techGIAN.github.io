
public class HW6Q5 {

	public static void TowerOfHanoi(int n, String fromRod, String toRod, String spareRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        TowerOfHanoi(n-1, fromRod, spareRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        TowerOfHanoi(n-1, spareRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        TowerOfHanoi(5, "Left", "Right", "Middle");
    }

}
