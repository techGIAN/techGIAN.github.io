import java.util.List;
import java.util.ArrayList;

public class ListEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> tenEvens = new ArrayList<>();
		for (int i = 0; i < 20; i += 2) {
			tenEvens.add(i);
		}
		List<Integer> twelveOdds = new ArrayList<>();
		for (int i = 1; i < 25; i += 2) {
			twelveOdds.add(i);
		}
		System.out.println(tenEvens);
		System.out.println(twelveOdds);
		tenEvens.addAll(twelveOdds);
		System.out.println(tenEvens);
	}

}
