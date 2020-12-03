class SavingAccount extends Account{ //extends keyword as it is a subclass of Account
    //two argument constructor
     SavingAccount(String accountID, double balance) {
         super(accountID, balance);
         //super is used as a reference variable to refer to the two arguments from the constructor or parent class (Account)
     }
        boolean withdraw(double amount) { //double value passed in as parameter
        int fee = 3; //withdrawing fee per transaction is 3
        if((balance-amount)>=10)//if statement if account balance is more or equal to 10, as it should be, enter condition if true
        {
          balance=balance-amount-fee; //deduct money and the fee
          return true; //must return a boolean true
        }
       System.out.println("You cannot withdraw given your balance, not enough money in account"); //sign appropriate message for not having enough money
       return false; //must return a boolean false
    }
   void deposit(double amount) { //double value passed as parameter
       if(amount > 1000){//if statement to check if amount is more than 1000
           balance=balance+amount+10.00;//enter condition if true, deposit amount plus 10.00 from bank credit
       } else{ //enter else condition if amount is less than 1000
           balance=balance+amount; //otherwise the amount is added to balance without extra credit
       }
    }
   //addInterest method taking (double rate)
    public double addInterest(double rate) {
        double interest = balance*(rate/100);//computes interest as a percentage
        balance = balance+interest;//adding interest to the existing balance
        return balance; //return value of balance for this method
    }
    //ToStringmethod update to include interest information
    public String toString(){
        return "[accountID: "+ accountID + ", balance: "+ balance+ ", Interest rate:"+ ", Interest Rate = 5%]"; //interest information added
    }
}
