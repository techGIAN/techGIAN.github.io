import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Homework9Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Object[]> employees = new ArrayList<>();
		String line = sc.nextLine();
		String[] arr = line.split(" ");
		char cmd = arr[0].charAt(0);
		String name = null;
		int age = 0;
		double fltArg = 0.0;
		double salary = 0.0;
		double percent = 0.0;
		int promotion = 0; 		// optional task only
		
		while (cmd != 'Q') {
			if (arr.length > 1)		name = arr[1];
			if (arr.length > 2)		fltArg = Double.parseDouble(arr[2]); 
			if (arr.length > 3)		age = Integer.parseInt(arr[3]);
			
			switch(cmd) {
			case 'H':
				if (getEmployees(employees).contains(name)) {
					System.out.println(name + " already exists.");
				} else {
					salary = fltArg;
					Object[] employee = {name, salary, age};
					employees.add(employee);
					System.out.println(name + " has just been hired.");
				}
				break;
			case 'F':
				if (!getEmployees(employees).contains(name)) {
					System.out.println(name + " does not exist.");
				} else {
					// explain why employees.remove(name) does not work
					Object[] record = getRecord(employees, name);
					employees.remove(record);
					System.out.println(name + " has just been fired.");
				}
				break;
			case 'R':
				if (!getEmployees(employees).contains(name)) {
					System.out.println(name + " does not exist.");
				} else {
					Object[] record = getRecord(employees, name);
					percent = fltArg;
					double raise = (1 + percent/100.0) * Double.parseDouble(record[1].toString());
					record[1] = raise;
					for (int i = 0; i < employees.size(); i++) {
						if (employees.get(i)[0].equals(name)) {
							employees.set(i, record);
						}
					}
					System.out.println(name + " has received a " + String.format("%.2f", percent) + "% raise.");
				}
				break;
			case 'A':
				if (!getEmployees(employees).contains(name)) {
					System.out.println(name + " does not exist.");
				} else {
					Object[] record = getRecord(employees, name);
					System.out.println(name + " is now " + record[2] + " years old.");
				}
				break;
			case 'E':
				if (!getEmployees(employees).contains(name)) {
					System.out.println(name + " does not exist.");
				} else {
					Object[] record = getRecord(employees, name);
					System.out.println(name + " is earning $" + String.format("%.2f", record[1]) + ".");
				}
				break;
			case 'D':
				printList(employees);
				break;
			case 'P':		// optional
				if (employees.size() <= promotion) {
					System.out.println("No one can be promoted at the moment.");
				} else {
					Object[] record = employees.get(promotion);
					promotion++;
					System.out.println(record[0] + " has just been promoted.");
				}
				break;
			case 'S':		// optional
				List<String> seniors = getSeniors(employees);
				if (seniors.isEmpty()) {
					System.out.println("There are no senior members.");
				} else {
					System.out.println("Seniors: ");
					for (String s : seniors) {
						System.out.println(s);
					}
				}
				break;
			case 'T':		// optional
				List<String> topEarners = topEarners(employees);
				if (topEarners.isEmpty()) {
					System.out.println("No one is a Top Earner.");
				} else {
					System.out.println("Top Earners: ");
					for (String e : topEarners) {
						System.out.println(e);
					}
				}
				break;
			default:
				System.out.println("Invalid command. Try again.");
				break;
			}
			
			line = sc.nextLine();
			arr = line.split(" ");
			cmd = arr[0].charAt(0);
		}
	}
	
	public static List<String> getEmployees(List<Object[]> l) {
		List<String> empNames = new ArrayList<>();
		
		for (Object[] o : l) {
			empNames.add(o[0].toString());
		}
		
		return empNames;
	}
	
	public static Object[] getRecord(List<Object[]> l, String name) {
		Object[] record = null;
		
		for (Object[] o : l) {
			if (o[0].toString().equals(name)) {
				record = o;
			}
		}
		
		return record;
	}
	
	public static List<String> getSeniors(List<Object[]> l) {
		List<String> seniors = new ArrayList<>();
		for (String name : getEmployees(l)) {
			Object[] record = getRecord(l, name);
			if (Integer.parseInt(record[2].toString()) >= 65) {
				seniors.add(name);
			}
		}
		return seniors;
	}
	
	public static List<String> topEarners(List<Object[]> l) {
		List<String> topEarners = new ArrayList<>();
		for (String name : getEmployees(l)) {
			Object[] record = getRecord(l, name);
			if (Double.parseDouble(record[1].toString()) >= 100000) {
				topEarners.add(name);
			}
		}
		return topEarners;
	}
	
	public static void printList(List<Object[]> l) {
		if (l.size() == 0)  {
			System.out.println("There are no employees in the list.");
			return;
		}
		System.out.println("Employees:");
		for (Object[] o : l) {
			System.out.println("* " + o[0] + ": {Salary: $" + String.format("%.2f", o[1]) + ", Age: " + o[2] + "}");	
		}
	}

}
