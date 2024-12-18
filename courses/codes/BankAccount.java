
public class BankAccount {
	
	private double balance;
	private double interestRate;
	
	public BankAccount() {
		this.balance = 1000;
		this.interestRate = 0.05;
	}
	
	public BankAccount(double balance) {
		this.balance = balance;
		this.interestRate = 0.05;
	}
	
	public BankAccount(double balance, double rate) {
		this.balance = balance;
		this.interestRate = rate;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	public void withdraw(double amt) {
		this.balance = Math.max(0, this.balance - amt);
	}
	
	public void withdrawAll() {
		this.balance = 0;
		// other ways of doing it
		// this.withdraw(this.balance);
		// this.withdraw(this.getBalance());
	}
	
	public void applyInterest() {
		this.balance *= (1 + this.interestRate);
	}
	
	
}
