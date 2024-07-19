
public class HW3Q6 {

	public static void main(String[] args) {
		System.out.println("Miles\tKilometres");
		for (int i = 1; i <= 25; i++) {
			System.out.println(String.format("%d\t%.2f", i, i*1.61));
		}
	}

}
