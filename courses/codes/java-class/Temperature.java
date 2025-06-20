import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Celsius: ");
		double C = sc.nextDouble();
//		C *= 9/5;
		C *= 9;
		C /= 5;
		C += 32;
		System.out.println("Fahrenheit: " + C);
	}

}
