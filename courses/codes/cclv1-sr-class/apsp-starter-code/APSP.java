import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class APSP {
	
	// MODIFY THIS!
	public static double[][] floydWarshall(double[][] W) {
		
		double[][] D = new double[W.length][W.length];
		
		// TO-DO
		
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
	
	// DO NOT MODIFY!
	// There is nothing to code in Q1 other than the Floyd-Warshall Algorithm
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
	

	// MODIFY THIS!
	public static void q2(String filename) {
		
        try (Scanner scanner = new Scanner(new File(filename))) {
        	
        	// DO NOT MODIFY
    		// READS THE INPUT Q2 FILE
    		// In the end, you should get W or the weights (time to travel from one node to another)
        	
            int N = Integer.parseInt(scanner.nextLine());
            int M = Integer.parseInt(scanner.nextLine());
            
            double[][] W = new double[N][N];
            
        	while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split(" ");
                int s = Integer.parseInt(arr[0]) - 1;
                int t = Integer.parseInt(arr[1]) - 1;
                double timeST = Double.parseDouble(arr[2]);
                double timeTS = Double.parseDouble(arr[3]);
                W[s][t] = timeST;
                W[t][s] = timeTS;
            }
        	
        	
        	// TO-DO
			// Complete this Method!
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
 
        
	}
	
	public static void main(String[] args) {
		// Comment/uncomment
		// q1("inputQ1.txt");
		// q2("inputQ2.txt");
	}

}
