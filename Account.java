public abstract class Account { //Defining Abstract class account
	String accountID; //Required field for accountID
	double balance; //Required field for balance
	public Account(String id, double balance) { //Account constructor
		this.accountID = id; //create constructor attribute id to initiate instance variables
		this.balance = balance; //create constructor attribute balance to initiate instance variables
	}
	//ToString message method
	public String toString() { 
		return "Account[accountID = " + this.accountID + ", Balance = " + this.balance + "]"; //Expecting a string to return with require
	}//method above must return string 
	abstract boolean withdraw(double ammount); //abstract methods withdraw 
	abstract void deposit(double ammount); //abstract method deposit
}
