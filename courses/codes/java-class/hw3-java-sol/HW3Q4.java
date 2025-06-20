import java.util.Scanner;

public class HW3Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a postive integer : ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " x " + n + " = " + i*n);
		}
	}

}
