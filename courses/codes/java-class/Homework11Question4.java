import java.util.Date;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Homework11Question4 {
	
	static Map<String, Date> birthdayBook = new HashMap<>();
	
	public static int getAge(String s) {
		Date now = new Date();
		Date birthdate = birthdayBook.get(s);
		long diffInMillies = now.getTime() - birthdate.getTime();
		int years = (int) (diffInMillies / (1000.0 * 60 * 60 * 24 * 365));
	    return years;
	}
	
	public static Set<String> upcomingBirthdays() {
		Date now = new Date();
		int monthNow = now.getMonth();
		Set<String> celebrants = new HashSet<>();
		for (Map.Entry<String, Date> e : birthdayBook.entrySet()) {
			String name = e.getKey();
			Date birthdate = e.getValue();
			int birthMonth = birthdate.getMonth();
			if ((monthNow + 1) % 12 == birthMonth) {
				celebrants.add(name);
			}
		}
		return celebrants;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] arr = line.split(" ");
		String cmd = arr[0];
		String name = null;			
		Date birthdate = null;			
		
		while (!cmd.equals("out")) {
			if (arr.length > 1)	name = arr[1];
			if (arr.length > 2) birthdate = new Date(arr[2]);
			
			switch(cmd) {
			case "add": 	// add <name> <date>
				if (birthdayBook.containsKey(name)) {
					System.out.println(name + " already exists in the birthday book.");
				} else {
					birthdayBook.put(name, birthdate);
					System.out.println(name + " was added.");
				}
				break;
			case "upd":		// upd <name> <date>
				if (birthdayBook.containsKey(name)) {
					birthdayBook.put(name, birthdate);
					System.out.println(name + " was updated.");
				} else {
					System.out.println(name + " does not exist in the birthday book.");
				}
				break;
			case "del":		// del <name>
				if (birthdayBook.containsKey(name)) {
					birthdayBook.remove(name);
					System.out.println(name + " was deleted.");
				} else {
					System.out.println(name + " does not exist in the birthday book.");
				}
				break;	
			case "qry":		// qry <name>
				if (birthdayBook.containsKey(name)) {
					birthdate = birthdayBook.get(name);
					String formattedDate = dateToString(birthdate);
					System.out.println(formattedDate);
				} else {
					System.out.println(name + " does not exist in the birthday book.");
				}
				break;	
			case "age":		// age <name>
				if (birthdayBook.containsKey(name)) {
					int age = getAge(name);
					System.out.println(name + " is " + age + " years old.");
				} else {
					System.out.println(name + " does not exist in the birthday book.");
				}
				break;	
			case "upc":		// upc
				Set<String> celebrants = upcomingBirthdays();
				if (celebrants.size() == 0) {
					System.out.println("There are no upcoming celebrants.");
				} else {
					System.out.println("Upcoming birthday celebrants:");
					for (String c : celebrants) {
						System.out.println(c);
					}
				}
				break;
			case "dsp":		// dsp
				prettyPrintMap("birthdayBook", birthdayBook);
				break;
			default:
				System.out.println("The command is not valid. Try again.");
				break;
			}
			
			line = sc.nextLine();
			arr = line.split(" ");
			cmd = arr[0];
		}
	
		
		
	}
	
	public static void prettyPrintMap(String mapName, Map<String, Date> m) {
		System.out.print(mapName + " = ");
		prettyPrintMap(m);
	}
	
	public static void prettyPrintMap(Map<String, Date> m) {
		System.out.println("{");
		for (Map.Entry<String, Date> e : m.entrySet()) {
			String k = e.getKey();
			Date v = e.getValue();
			String formattedDate = dateToString(v);
			
			System.out.print("  " + k + " ==> ");
			System.out.println(formattedDate);
		}
		System.out.println("}");
	}
	
	public static String dateToString(Date d) {
		DateFormat fmt = new SimpleDateFormat("MM-dd-yyyy");
		String formattedDateText = fmt.format(d);
		return formattedDateText;
	}

}
