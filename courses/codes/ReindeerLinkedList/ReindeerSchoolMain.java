
public class ReindeerSchoolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReindeerSchool rs = new ReindeerSchool();
		rs.printCountStatus();
		
		Reindeer rudolph = new Reindeer("Rudolph");
		rs.enrol(rudolph);
		rs.printCountStatus();
		
		Reindeer comet = new Reindeer("Comet");
		Reindeer dasher = new Reindeer("Dasher");
		rs.enrol(comet);
		rs.enrol(dasher);
		rs.printCountStatus();
		rs.printReindeers();
		
		Reindeer vixen = new Reindeer("Vixen");
		rs.printSearchStatus(vixen.name);
		rs.enrol(vixen);
		rs.printCountStatus();
		
		rs.drop(comet);
		rs.printReindeers();
		rs.printCountStatus();
		rs.printSearchStatus(comet.name);
		
		rs.drop(rudolph);
		rs.printReindeers();
		rs.printCountStatus();
		rs.printSearchStatus(comet.name);
	}

}
