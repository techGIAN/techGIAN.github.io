
public class ReindeerSchool {
	
	private Reindeer leader;
	private int count;
	
	public ReindeerSchool() {
		this.leader = null;
		this.count = 0;
		System.out.println("Reindeer School created.");
	}
	
	public void enrol(Reindeer r) {
		if (this.leader == null) {
			this.leader = r;
		} else {
			Reindeer temp = this.leader;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = r;
		}
		this.count++;
		this.printEnrolStatus(r.name);
	}
	
	
	public String drop(Reindeer r) {
		if (this.count == 0 || !this.search(r.name)) {
			return "";
		}
		String name = "";
		Reindeer temp = this.leader;
		if (r.equals(temp)) {
			if (this.count == 1) {
				this.leader = null;
			} else {
				this.leader = r.next;
			}
		} else {
			while (temp.next != null) {
				if (temp.next.equals(r)) {
					temp.next = r.next;
					break;
				}
			}
		}
		
		this.count--;
		this.printDropStatus(r.name);
		return r.name;
	}
	
	public boolean search(String s) {
		Reindeer temp = this.leader;
		while (temp != null) {
			if (temp.name.equals(s)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	// ===========================================
	//	Mainly for checking status; DO NOT MODIFY!
	// ===========================================
	
	public void printReindeers() {
		String S = "[";
		Reindeer temp = this.leader;
		while (temp != null) {
			S += temp.name + " --> ";
			temp = temp.next;
		}
		if (this.count > 0)
			S = S.substring(0, S.length()-5);
		S += "]";
		System.out.println("Reindeers: " + S);
	}
	
	public void printCountStatus() {
		
		if (this.count == 0) {
			System.out.println("There are currently " + this.count + " reindeers enrolled in the Reindeer School.");
		} else {
			System.out.println("There are currently " + this.count + " reindeers enrolled in the Reindeer School, led by " + this.leader.name + ".");
		}
		
	}
	
	public void printEnrolStatus(String rName) {
		System.out.println("Reindeer " + rName + " has been enrolled in the Reindeer School.");	
	}
	
	public void printDropStatus(String rName) {
		System.out.println("Reindeer " + rName + " has been dropped from the Reindeer School.");	
	}
	
	
	
	public void printSearchStatus(String rName) {
		
		if (this.search(rName)) {
			System.out.println("Reindeer " + rName + " is enrolled in the Reindeer School.");
		} else {
			System.out.println("Reindeer " + rName + " is not enrolled in the Reindeer School.");
		}
		
			
	}


}

