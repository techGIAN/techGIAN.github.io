import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numerical grade: ");
		int grade = Integer.parseInt(sc.nextLine());
		
		String letterGrade = "Invalid";
		
		if (grade >= 90 && grade <= 100) {
			letterGrade = "A";
		} else if (grade >= 80 && grade < 90) {
			letterGrade = "B";
		} else if (grade >= 70 && grade < 80) {
			letterGrade = "C";
		} else if (grade >= 60 && grade < 70) {
			letterGrade = "D";
		} else if (grade >= 0 && grade < 60) {
			letterGrade = "F";
		}
		
		// Alternative Solution
		if (grade > 100 || grade < 0) {
			letterGrade = "Invalid";
		} else if (grade >= 90) {
			letterGrade = "A";
		} else if (grade >= 80) {
			letterGrade = "B";
		} else if (grade >= 70) {
			letterGrade = "C";
		} else if (grade >= 60) {
			letterGrade = "D";
		} else if (grade >= 0) {
			letterGrade = "F";
		}
		
		
		
		System.out.println(letterGrade);
	}

}
