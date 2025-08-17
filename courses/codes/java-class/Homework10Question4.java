import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Homework10Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] arr = line.split(" ");
		char cmd = arr[0].charAt(0);
		String name1 = null;
		String name2 = null;
		Set<String> users = new HashSet<>();
		Set<Set<String>> friendships = new HashSet<>();
		
		while (cmd != 'q') {
			if (arr.length > 1) name1 = arr[1];
			if (arr.length > 2) name2 = arr[2];
			
			switch (cmd) {
			case 'r':
				if (users.contains(name1)) {
					System.out.println("User " + name1 + " already exists.");
				} else {
					users.add(name1);
					System.out.println("User " + name1 + " has been registered to Fakebook.");
				}
				break;
			case 'f':
				if (!users.contains(name1) || !users.contains(name2)) {
					System.out.println("One or both users is not registered.");
				} else {
					Set<String> friendship = Set.of(name1, name2);
					if (friendships.contains(friendship)) {
						System.out.println(name1 + " and " + name2 + " are already friends.");
					} else {
						friendships.add(friendship);
						System.out.println(name1 + " and " + name2 + " are now friends.");
					}
				}
				break;
			case 'u':
				if (!users.contains(name1) || !users.contains(name2)) {
					System.out.println("One or both users is not registered.");
				} else {
					Set<String> friendship = Set.of(name1, name2);
					if (friendships.contains(friendship)) {
						friendships.remove(friendship);
						System.out.println("Users " + name1 + " and " + name2 + " are no longer friends.");
					} else {
						System.out.println("No friendship relation between " + name1 + " and " + name2 + ".");
					}
				}
				break;
			case 'a':
				if (!users.contains(name1)) {
					System.out.println("User " + name1 + " is not registered.");
				} else {
					Set<String> friends = getAllFriends(friendships, name1);
					if (friends.size() == 0) {
						System.out.println("User " + name1 + " has no registered friends. ");
					} else {
						System.out.println("Friends of User " + name1 + " on Fakebook:");
						for (String friend : friends) {
							System.out.println("* " + friend);
						}
					}
				}
				break;
			case 's':
				if (!users.contains(name1) || !users.contains(name2)) {
					System.out.println("One or both users is not registered.");
				} else {
					Set<String> friendship = Set.of(name1, name2);
					if (friendships.contains(friendship)) {
						System.out.println("Users " + name1 + " and " + name2 + " are Fakebook friends.");
					} else {
						System.out.println("Users " + name1 + " and " + name2 + " are not Fakebook friends.");
					}
				}
				break;
			case 'd':
				if (!users.contains(name1)) {
					System.out.println("User " + name1 + " is not registered.");
				} else {
					users.remove(name1);
					Set<String> friends = getAllFriends(friendships, name1);
					for (String friend : friends) {
						Set<String> friendship = Set.of(name1, friend);
						friendships.remove(friendship);
					}
					System.out.println("User " + name1 + "'s account has been deactivated.");
				}
				break;
			case 'p':
				prettyPrintFriendships(friendships);
				break;
			case 'm':		// optional
				if (!users.contains(name1) || !users.contains(name2)) {
					System.out.println("One or both users is not registered.");
				} else {
					Set<String> m = mutualFriends(friendships, name1, name2);
					if (m.size() == 0) {
						System.out.println("Users " + name1 + " and " + name2 + " have no mutual friends.");
					} else {
						System.out.println("Mutual friends of " + name1 + " and " + name2 + ":");
						for (String n : m) {
							System.out.println("* " + n);
						}
					}
				}
				break;
			case 'o':		// optional
				if (!users.contains(name1)) {
					System.out.println("User " + name1 + " is not registered.");
				} else {
					Set<String> fofs = friendsOfFriends(friendships, name1);
					if (fofs.size() == 0) {
						System.out.println("User " + name1 + " have no friends of friends.");
					} else {
						System.out.println("Friends of friends of " + name1 + ":");
						for (String n : fofs) {
							System.out.println("* " + n);
						}
					}
				}
				break;
			default:
				System.out.println("Invalid command. Please try again.");
				break;
			}
			
			line = sc.nextLine();
			arr = line.split(" ");
			cmd = arr[0].charAt(0);
		}
		
		sc.close();
	}
	
	public static Set<String> getAllFriends(Set<Set<String>> friendships, String name) {
		Set<String> friends = new HashSet<>();
		for (Set<String> friendship : friendships) {
			if (friendship.contains(name)) {
				String[] f = new String[2];
				friendship.toArray(f);
				if (f[0].equals(name)) friends.add(f[1]);
				else friends.add(f[0]);
			}
		}
		return friends;
	}
	
	public static void prettyPrintFriendships(Set<Set<String>> friendships) {
		if (friendships.size() == 0) {
			System.out.println("There are no Fakebook friendships.");
		} else {
			System.out.println("Fakebook friends:");
			for (Set<String> friendship : friendships) {
				String[] f = new String[2];
				friendship.toArray(f);
				System.out.println("* " + f[0] + " <==> " + f[1]);
			}
		}
	}
	
	public static Set<String> mutualFriends(Set<Set<String>> friendships, String name1, String name2) {
		Set<String> name1Friends = getAllFriends(friendships, name1);
		Set<String> name2Friends = getAllFriends(friendships, name2);
		name1Friends.retainAll(name2Friends);
		Set<String> mutualFriends = new HashSet<>(name1Friends);
		return mutualFriends;
	}
	
	public static Set<String> friendsOfFriends(Set<Set<String>> friendships, String name) {
		Set<String> fofs = new HashSet<>();
		Set<String> friends = getAllFriends(friendships, name);
		for (String friend : friends) {
			Set<String> f = getAllFriends(friendships, friend);
			f.remove(name);
			fofs.addAll(f);
		}
		return fofs;
	}
}
