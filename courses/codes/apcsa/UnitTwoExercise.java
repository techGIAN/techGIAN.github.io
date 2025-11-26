// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class UnitTwoExercise {
    
    public static String weather(double temp) {
        if (temp > 40) return "Scorching";
        else if (temp > 30) return "Hot";
        else if (temp >= 15) return "Mild";
        else if (temp >= 0) return "Chilly";
        else if (temp > -20) return "Cold";
        else return "Freezing";
    }
    
    public static boolean identicalFirstChar(String a, String b, String c) {
        return (a.substring(0,1).equals(b.substring(0,1))) && (c.substring(0,1).equals(b.substring(0,1)));
    }
    
    public static String gradeMessage(double q1, double q2, double q3, double q4, double q5) {
        double ave = (q1 + q2 + q3 + q4 + q5) / 5;
        String msg = "Your score is " + ave + ". ";
        
        if (ave >= 80)
            msg += "Excellent work!";
        else if (ave >= 60)
            msg += "Very good!";
        else if (ave >= 40)
            msg += "Average, try harder!";
        else if (ave >= 20)
            msg += "Unsatisfactory!";
        else
            msg += "Needs improvement!";
            
        return msg;
    }
    
    public static void countdown(int n) {
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("BLAST OFF!");
    }
    
    public static int diceRolls() {
        int count = 1;
        int d1 = (int) (Math.random() * 6) + 1;
        int d2 = (int) (Math.random() * 6) + 1;
        while (d1 + d2 != 9) {
            count++;
            d1 = (int) (Math.random() * 6) + 1;
            d2 = (int) (Math.random() * 6) + 1;
        }
        return count;
    }
    
    public static void printNums(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n*i; j += i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    public static int whereToFind(String s1, String s2) {
        int n = s2.length();
        int ix = -1;
        for (int i = 0; i < s1.length() - n + 1; i++) {
            if (s1.substring(i, i+n).equals(s2))    ix = i;
        }
        return ix;
    }
    
    public static int largestDigit(int n) {
        int x = n;
        int max = -1;
        while (x > 0) {
            int r = x % 10;
            x /= 10;
            if (r > max) max = r;
        }
        return max;
    }
    
    public static char largestChar(String str) {
        String s = str;
        char max = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > max)
                max = s.charAt(i);
        }
        return max;
    }
    
}