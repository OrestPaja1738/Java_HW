public class Bank_Account {
private String accountNumber;
private String accountHolder;
private double balance;

    public Bank_Account(String accountNumber,String accountHolder,double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder(){
        return  accountHolder;
    }
    //special method start
    public void deposit(double amount){
        this.balance += amount;
    }
    public void withdrawing(double amount){
        this.balance -= amount;
    }
}
