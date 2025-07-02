package banking.model;

public class CurrentAccount extends Account {

    public CurrentAccount(String id, String name) {
        super(id, name);
    }
    public CurrentAccount(String id, String name, int balance) {
        super(id, name, balance);
    }
    @Override
    public double interest() {
        return 0.0;
    }
}
