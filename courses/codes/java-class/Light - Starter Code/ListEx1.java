import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> smallPrimes = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		for (Integer p : smallPrimes) {
			System.out.println(p);
		}
	}

}
