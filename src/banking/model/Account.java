package banking.model;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public Account(String id, String name){
        this.id = id;
        this.name = name;
        this.balance = 0;
    }
    public Account(String id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    abstract double interest();
    public double credit(double amount) {
        balance += amount;
        return balance;
    }
    public double debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
        else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    public double transferTo(Account destination, double amount) {
        if (amount <= balance) {
            destination.credit(amount);
            this.debit(amount);
            System.out.println("Amount of " + amount + " transferred to " + destination.getId() + " to " + id);
        }
        else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[Id=" + id + ", Name=" + name + ", Balance=" + balance + "]";
    }
}

