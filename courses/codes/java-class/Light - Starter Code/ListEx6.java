import java.util.List;
import java.util.ArrayList;

public class ListEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> hundredEvens = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			hundredEvens.add(2*i);
		}
		System.out.println(rev(hundredEvens));
	}
	
	public static List<Integer> rev(List<Integer> l) {
		List<Integer> reversedList = new ArrayList<>();
		for (int i = l.size()-1; i >= 0; i--) {
			reversedList.add(l.get(i));
		}
		return reversedList;
	}

}
