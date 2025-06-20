import java.util.Scanner;

public class Leap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        boolean isLeap = false;
        
        // Solution 1
        if (year % 4 == 0) {
            isLeap = !isLeap;
        }
        if (year % 100 == 0) {
            isLeap = !isLeap;
        }
        if (year % 400 == 0) {
            isLeap = !isLeap;
        }
        
        // Solution 2
        if (year % 400 == 0) {
            isLeap = true;
        } else if (year % 100 == 0) {
            isLeap = false;
        } else if (year % 4 == 0) {
            isLeap = true;
        }
        
        if (isLeap) {
            System.out.println(String.format("%d is a leap year.", year));
        } else {
            System.out.println(String.format("%d is not a leap year.", year));
        }
    }
}