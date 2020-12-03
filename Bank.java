import java.util.ArrayList; //importing array list package
class Bank { //class signature bank
    String name; //filed to hold bank name
    double savingsInterestRate;  //field to hold rate of interests for Savings in percentage
    Bank(String name, double savingsInterestRate){ //constructor for bank
    	this.name = name; //construct instance variable to be used name
    	this.savingsInterestRate = savingsInterestRate; //construct instance variable to be used savings interest rate
    }
    static ArrayList<Account> listOfAccounts = new ArrayList<>();
    //Static variable listOfAccounts created as ArrayList
    
    //Method deposit
    boolean deposit(String accountID, double amount) { //signature of method and parameters accountID and amounts
        for (Account listOfAccount : listOfAccounts) { //for loop parsing through array list
            if (listOfAccount.accountID.equals(accountID)) { //this checks the account ID .equals is used for content comparison, if this true then move to next line
                listOfAccount.balance = listOfAccount.balance + amount; //proceed and update balance of the account in question with the amount entered as argument
                return true; //return true for this method
            }
        }
        return false; //if checks are unsuccessful return false
    }
    boolean withdraw(String accountID, double amount){ //method withdraw signature
    	for(int i = 0;i<listOfAccounts.size();i++) { //for loop parsing through each account in array list list of account
    		if(listOfAccounts.get(i).accountID.equals(accountID)){ //for each element, check account id, if true proceed to next line
    			listOfAccounts.get(i).balance = listOfAccounts.get(i).balance - amount; //deduct money from account in question after check
    		}
    		if(listOfAccounts.get(i).balance < 0) { //if balance is less than limit
    			System.out.println("Sorry, over the limit, you cannot withdraw"); //sign appropriate message
    			listOfAccounts.get(i).balance = listOfAccounts.get(i).balance + amount; //update balance with 0
    			return false; //return false
    		}
    	}
    	return true; //return true for withdraw
    }
    //method transfer
     boolean transfer(String fromAccountID, String toAccountID, double amount){ //signature and parameters for two accounts and amount to interchange
    	for(int i = 0;i<listOfAccounts.size();i++) { //nested for loop necessary to parse through two accounts - i 
    		for(int j=0;j<listOfAccounts.size();j++) { //nested for loop necessary to parse through two accounts - j
    			if(listOfAccounts.get(i).accountID.equals(fromAccountID) && listOfAccounts.get(j).accountID.equals(toAccountID)) //if the account ID check is true for both account, then proceed
			{
    			listOfAccounts.get(i).balance = listOfAccounts.get(i).balance - amount; //deduct money from first account
    			listOfAccounts.get(j).balance = listOfAccounts.get(j).balance + amount; //add money to second account
    			return true; //successful operation so return true
			}
    	}
    	}
    	return false; //otherwise return false
    }
}