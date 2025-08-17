
public class MainRacer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Racer r = new Racer();
		System.out.println(r.getName());
		r.refuel(20);
		r.start();
		r.drive(150);
		r.drive(70);
		r.drive(10);
		r.refuel(80);
		r.refuel(30);
		r.drive(10);
		r.start();
		r.drive(50);
		r.stop();
		r.setName("Hudson");
		System.out.println(r.getName());
	}

}
