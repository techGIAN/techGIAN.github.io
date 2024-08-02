import java.util.List;
import java.util.ArrayList;

public class ListEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> hundredEvens = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			hundredEvens.add(2*i);
		}
		List<Integer> midEvens = new ArrayList<>(hundredEvens.subList(33, 67));
		System.out.println(midEvens);
	}

}
