import java.util.List;

public class ListEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> tenEvens = List.of(0, 2, 4, 6, 8, 10, 12, 14, 16, 18);
		for (int i = 1; i < tenEvens.size(); i+=2) {
			System.out.println(tenEvens.get(i));
		}
	}

}
