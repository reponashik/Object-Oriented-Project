class CurrentAccount extends Account { //subclass extending from account
    public int numberOfChecksUsed; //field of number of checks 
    public CurrentAccount(String accountID, double balance, int numberOfChecksUsed) { //constructor signature
        super(accountID, balance); //super referring to instance variables from parent class
        this.numberOfChecksUsed = numberOfChecksUsed; //constructing instance variable numberofchecksused
    }
    //update toStringMethod
    public String toString(){
        return "[accountID: "+ accountID + ", balance: "+ balance+ ", Number of Checks: "+ numberOfChecksUsed+"]"; //updated with numberofchecks
    }
    //withdraw version of currentaccount, still taking amount as parameter as a double value
    boolean withdraw(double amount) { //method signature
        int fee=1; //fee for withdrawing is now set to 1
        if((balance-amount)>=0) { //if your current balance minus the amount is more than or equal to 0. then proceed to condition
            balance=balance-amount-fee; //withdraw money by deducting the fee of 1 and the amount entered to be withdrawn 
            return true;// return boolean value true if conditions apply
        }
         if((balance-amount)<0)//if statement to check if balance is below 0
        {
            System.out.println("Your balance cannot go below 0"); //sign appropriate message
            return false; //return boolean false
        }
     return true; //return true for method withdraw is balance is positive
    }
    void deposit(double amount) { //signature of method deposit
        if(amount < 1) { //if statement to check amount is less than 1 
            System.out.println("Deposit fail"); //sign appropriate message
        }
       if(amount >= 1){ //if statement to check if amount is correct so more than 1 
           balance=balance+amount-1;//update balance with amount taking away fee of 1
       }
    }
    public void resetChecksUsed() //signature of reset checks used
    {
        numberOfChecksUsed = 0; //updates the variable number of checks used back to zero if called
    }
    public boolean withdrawUsingChecks(double amount){ //withdraw using check method signature
            boolean success=true; //set success to true to start
            if( numberOfChecksUsed<3){ //enter if number of checks is less than 3 
                if((balance-amount)>=-10){ //checking limit
                    balance=balance-amount; //if more or equal to -10, proceed with withdraw and incement check
                    numberOfChecksUsed++; //increment checks
                }
                else{
                    balance=balance; //update balance
                    System.out.println("Sorry, you have reached overdraft"); //sign overdraft message
                    success=false; //success set to false
                }
            }
            else{ //this else condition is executed if the number of checks used is more than 3
                if((balance-amount)>=-10){ //setting normal withdraw with positive balance
                    balance=balance-amount-2; //compute balance with fee of 2 applied
                    numberOfChecksUsed++; //checks increased
                }
                else{
                    balance=balance; //update balance
                    System.out.println("Sorry, you have reached overdraft"); //sign overdraft message
                    success=false; //success set to false
                }
            }
            return success; //return boolean value
    }
}
