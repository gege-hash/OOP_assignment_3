package banking.model;

public class PremiumAccount extends Account {
    private int depositCount;
    public PremiumAccount(String id, String name) {
        super(id, name);
    }
    public PremiumAccount(String id, String name, int balance) {
        super(id, name, balance);
    }
    @Override
    public double interest(){
        double balance = getBalance();
        return balance * 0.07;
    }
    @Override
    public double credit(double amount) {
        double balance = getBalance();
        depositCount++;
        return super.credit(amount) + interest();
    }
    @Override
    public double debit(double amount) {
        double balance = getBalance();
        if (depositCount >= 5) {
            if(balance >= amount){
                return super.debit(amount);
            }
            else {
                System.out.println("Insufficient balance");
            }
        }
        else{
            System.out.println("You MUST deposit 5 times before you can withdraw");
        }
        return balance;
    }
    @Override
    public double transferTo(Account destination, double amount){
        System.out.println("Can't transfer money from premium account");
        return getBalance();
    }
}
