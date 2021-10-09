// import java.util.Random;

public class BankAccount {
    // Attributes (double)checking balance and (double) saving balance
    private double checkingBalance;
    private double savingBalance;
    // class member (static) that has the number of accounts created so far
    private static int numberOfAccounts = 2;
    //class member (static) that has the amount of money in accounts
    private static double amountOfMoney;

    //Deposit
    public void depositMoney(double amount, String accountType){
        //TO DEPOSIT TO CHECKING
        if (accountType.equals("Checking")){
            //Set checkingBalance
            this.setCheckingBalance(this.getCheckingBalance() + amount);
            //TO DEPOSIT TO SAVING
        } else if (accountType.equals("Saving")){
            //set saving balance
            this.setSavingBalance(this.getSavingBalance() + amount);
        } else {
            System.out.println("Invalid Account Type");
            return;
        }
        amountOfMoney += amount;
    }

    //Withdraw
    public void withdrawMoney(double amount, String accountType){
        //To withdraw money from checking
            if (accountType.equals("Checking")){
                //Dont allow overdraft
                if (this.getCheckingBalance() - amount < 0){
                    System.out.println("Insufficient Funds");

                } else {
                    this.setCheckingBalance(this.getCheckingBalance() - amount);
                }
                //TO withdraw from savings
            } else if (accountType.equals("Saving")){
                //Dont allow overdraft
                if(this.getSavingBalance() - amount < 0){
                    System.out.println("Insufficient Funds");

                } else{
                    this.setSavingBalance(this.getSavingBalance() - amount);
                }                
            } else {
                System.out.println("Invalid Account Type");
                return;
            }
            amountOfMoney -= amount;
        }

    //Account Total
    public String getAccountTotal(){
        return "Account Total: " + (this.getCheckingBalance() + this.getSavingBalance());
    }

    //Getters and Setters
    public double getCheckingBalance(){
        return checkingBalance;
    }

    private void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }
    
    private void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }

    public void setNumberOfAccounts(int numberOfAccounts){
        BankAccount.numberOfAccounts = numberOfAccounts;
    }

    public static double getAmountOfMoney(){
        return amountOfMoney;
    }

    public static void setAmountOfMoney(double amountOfMoney){
        BankAccount.amountOfMoney = amountOfMoney;
    }

}

