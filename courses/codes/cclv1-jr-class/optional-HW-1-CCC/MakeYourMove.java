import java.util.Scanner;

public class MakeYourMove {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] source = sc.nextLine().split(" ");
		int x0 = Integer.parseInt(source[0]);
		int y0 = Integer.parseInt(source[1]);
		
		// initializations
		int x = x0;
		int y = y0;
		boolean isOn = false;
		int bat = 50;
		
		System.out.println(x + " " + y);
		
		String cmd = sc.nextLine();
		
		// for Java, cmd != "Q" will not work
		while (!cmd.equals("Q")) {
			
			if (cmd.equals("C")) {
				bat = 100;
			} else if (cmd.equals("P") && bat > 0) {
				isOn = !isOn;
			} else {
				String[] arr = cmd.split(" ");
				String dirn = arr[0];
				int steps = (!isOn) ? 0 : ((arr.length == 1) ? 1 : Integer.parseInt(arr[1]));
				
				if (dirn.equals("F")) {
					y += Math.min(steps, bat);
				} else if (dirn.equals("B")) {
					y -= Math.min(steps, bat);
				} else if (dirn.equals("L")) {
					x -= Math.min(steps, bat);
				} else {
					x += Math.min(steps, bat);
				}
				
				bat -= Math.min(steps, bat);
				
			}
			
			if (bat == 0) {
				isOn = false;
			}
			
			System.out.println(x + " " + y);

			cmd = sc.nextLine();
			
		}
		
		double d = Math.sqrt((x - x0)*(x - x0) + (y - y0)*(y - y0));
		System.out.println(String.format("%.2f", d));
		
		sc.close();
	}

}
