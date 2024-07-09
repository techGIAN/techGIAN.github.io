import java.util.Scanner;

public class Cylinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("radius: ");
		double r = sc.nextDouble();
//		double r = Double.parseDouble(sc.nextLine());
		System.out.print("height: ");
		double h = sc.nextDouble();
		double V = Math.PI * r * r * h;
		System.out.println("Volume: " + V);
	}

}
