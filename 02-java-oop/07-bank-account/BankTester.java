public class BankTester{
    public static void main(String[] args) {
        BankAccount myBankAccount = new BankAccount();
        myBankAccount.depositMoney(10,"Saving");
        myBankAccount.depositMoney(1000,"Checking");
        System.out.println(myBankAccount.getAccountTotal());
        myBankAccount.depositMoney(100, "Saving");
        System.out.println(myBankAccount.getAccountTotal());
        System.out.println(BankAccount.getNumberOfAccounts());
        System.out.println(BankAccount.getAmountOfMoney());
        myBankAccount.withdrawMoney(1000, "Checking");
        myBankAccount.withdrawMoney(60, "Saving");
        System.out.println(myBankAccount.getAccountTotal());
    }
}