import java.util.List;
import java.util.ArrayList;

public class ListEx3 {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 21; i++) {
			nums.add(i);
		}
		System.out.println(nums);
		nums.remove(4);
		System.out.println(nums);
	}

}
