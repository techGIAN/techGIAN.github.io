
public class Racer {

	private String name;
	private double fuel;
	private boolean engineOn;
	
	public Racer() {
		this.name = "McQueen";
		this.fuel = 0.0;
		this.engineOn = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getFuel() {
		return this.fuel;
	}
	
	public boolean isEngineOn() {
		return this.engineOn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void refuel(double volume) {
		double initFuel = this.fuel;
		double finalFuel = initFuel + volume;
		
		// fixes the issue of the max capacity
		if (finalFuel >= 100) {
			volume = (finalFuel - 100);
			finalFuel = 100;
		}
		
		this.fuel = finalFuel;
		
		System.out.println("The amount of fuel added to the racer car is " + volume + " litres and it now has a fuel level of " + this.fuel + " litres.");
	}
	
	public void start() {
		if (this.fuel == 0.0) {
			System.out.println("Won't start; fuel is zero.");
			return;
		}
		if (this.engineOn) {
			System.out.println("Engine is already on.");
			return;
		}
		this.engineOn = true;
		System.out.println("Engine is now turned on.");
	}
	
	public void stop() {
		if (!this.engineOn) {
			System.out.println("Engine is already off.");
		} else {
			this.engineOn = false;
			System.out.println("Engine is now turned off.");
		}
	}
	
	public void drive(double distance) {
		if (this.fuel == 0.0) {
			System.out.println("Out of fuel; cannot drive.");
			return;
		}
		if (!this.isEngineOn()) {
			System.out.println("Engine is off; cannot drive.");
			return;
		}
		
		double currFuel = this.getFuel();
		double fuelDistanceCovered = currFuel * 10;
		double fuelRequired = distance / 10;
		double distanceCovered;
		if (distance > fuelDistanceCovered) {
			this.engineOn = false;
			distanceCovered = fuelDistanceCovered;
			this.fuel = 0.0;
			System.out.print("Out of fuel. Please refuel. ");
		} else {
			distanceCovered = distance;
			this.fuel = currFuel - fuelRequired;
		}
		System.out.println("Distance covered is: " + distanceCovered + " km and it has a fuel level of " + this.fuel + " litres.");
	}
}
