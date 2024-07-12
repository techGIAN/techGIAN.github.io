import java.util.Scanner;

public class HW1Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is your name? ");
		String name = sc.nextLine();
		
		System.out.print("How old are you, " + name + "? ");
		String age = sc.nextLine();
		
		System.out.println("Hello " + name + ", you are " + age + " years old.");
	}
	
}
