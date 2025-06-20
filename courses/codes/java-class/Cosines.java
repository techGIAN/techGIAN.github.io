// One thing to note is that class names have to match your Java filenames
public class Cosines {

	public static void main(String[] args) {
		// This is a comment
		// Java does not read comments
		// Comments are mostly for the human eye
		
		double one = Math.cos(0.1);			// cos(0.1)
		double two = Math.cos(0.2);			// cos(0.2)
		double three = Math.cos(0.3);		// cos(0.3)
		double pie = Math.cos(Math.PI);		// cos(pi)
		
		// print the results
		System.out.println(String.format("%.6f", one));
		System.out.println(String.format("%.6f", two));
		System.out.println(String.format("%.6f", three));
		System.out.println(String.format("%.6f", pie));
		
		// alternative way:
		// another way of print formatting with printf
		// note that printf does not automatically print a new line
		// so we add a new line ourselves manually with \n
		System.out.printf("%.6f\n", one);
		System.out.printf("%.6f\n", two);
		System.out.printf("%.6f\n", three);
		System.out.printf("%.6f\n", pie);
		
	}

}
