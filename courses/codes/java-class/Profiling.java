
public class Profiling {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();		// Get current time
		
		// Body of program does nothing but compute cos(0.2) a million times
		for (int i = 0; i < 1000000; i++) {
			double x = Math.cos(0.2);
		}
		
		long endTime = System.nanoTime();		// Get current time
		long timeDelta = endTime - startTime;	// Compute time elapsed
		System.out.println("My program took " + timeDelta + " ns to run.");
		
	}

}
