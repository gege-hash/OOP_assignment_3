package banking.model;

public class SavingsAccount extends Account {
    public SavingsAccount(String id, String name) {
        super(id, name);
    }
    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }
    @Override
    public double interest(){
        double balance = getBalance();
        return balance * 0.025;
    }
    @Override
    public double credit(double amount) {
        return super.credit(amount) + interest();
    }
    @Override
    public double debit(double amount) {
        double balance = getBalance();
        if (balance - amount >= 1000) {
            return super.debit(amount);
        } else {
            System.out.println("balance is too small");
            return balance;
        }
    }
}

