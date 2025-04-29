import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class APSP {
	
	public static double[][] floydWarshall(double[][] W) {
		
		double[][] D = new double[W.length][W.length];
		for (int i = 0; i < D.length; i++) {
			Arrays.fill(D[i], Double.MAX_VALUE);
		}
		
		for (int i = 0; i < W.length; i++) {
			for (int j = 0; j < W.length; j++) {
				if (W[i][j] > 0) {
					D[i][j] = W[i][j];
				}
			}
		}
		
		for (int n = 0; n < W.length; n++) {
			D[n][n] = 0;
		}
		
		for (int k = 0; k < W.length; k++) {
			for (int i = 0; i < W.length; i++) {
				for (int j = 0; j < W.length; j++) {
					D[i][j] = Math.min(D[i][j], addXY(D[i][k], D[k][j]));
				}
			}
		}
		
		return D;
		
		
	}
	
	// DO NOT MODIFY!
	// simulates x + y and avoids overflows especially when arguments are infinity
	public static Double addXY(double x, double y) {
		if (x == Double.MAX_VALUE || y == Double.MAX_VALUE) {
			return Double.MAX_VALUE;
		} else if (x == Double.MIN_VALUE || y == Double.MIN_VALUE) {
			return Double.MIN_VALUE;
		} else {
			return x + y;
		}
	}
	
	
	public static void q1(String filename) {
		
		// DO NOT MODIFY
		// READS THE INPUT Q1 FILE
		// In the end, you should get adj matrix weights
		List<String> lines = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(new File(filename))) {
        	
        	while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		int n = lines.get(0).split(" ").length;
		double[][] weights = new double[n][n];
		
		int i = 0;
		for (String line : lines) {
			String[] arr = line.split(" ");
			for (int j = 0; j < arr.length; j++) {
				weights[i][j] = Double.parseDouble(arr[j]);
			}
			i++;
		}
		
		double[][] dist = floydWarshall(weights);
		for (double[] d : dist) {
			int[] integers = new int[d.length];
			for (int j = 0; j < d.length; j++) {
				integers[j] = (int) d[j];
			}
			
			System.out.println(Arrays.toString(integers));
		}
		

	}
	
	
	
	public static void main(String[] args) {
		q1("inputQ1.txt");
	}

}
