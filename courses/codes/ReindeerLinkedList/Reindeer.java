public class Reindeer {
	
	public String name;
	public Reindeer next;
	
	public Reindeer() {
		this("", null);
	}
	
	public Reindeer(String name) {
		this(name, null);
	}
	
	public Reindeer(String name, Reindeer next) {
		this.name = name;
		this.next = next;
	}
	
}