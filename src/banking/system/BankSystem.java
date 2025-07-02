package banking.system;

import banking.model.*;

import java.util.Scanner;

public class BankSystem {
    private Account[][] accounts = new Account[3][100];
    private int accountIDcounter = 3;
    private int []index = {1,1,1};
    Scanner input = new Scanner(System.in);

    public BankSystem() {
        accounts[0][0] = new CurrentAccount("0000", "Ratul");
        accounts[1][0] = new SavingsAccount("0001", "Nafis", 5000);
        accounts[2][0] = new PremiumAccount("0002", "Sinha", 1000);
    }
    public Account findAccountById(String id) {
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < index[i]; j++) {
                if (accounts[i][j].getId().equals(id) && accounts[i][j] != null) {
                    return accounts[i][j];
                }
            }
        }
        return null;
    }
    public void showMenu(){
        System.out.println("\n=== MENU ===");
        System.out.println("1. Create new account");
        System.out.println("2. Debit");
        System.out.println("3. Credit");
        System.out.println("4. Transfer");
        System.out.println("5. Show balance sheet");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
    public void createAccount() {
        System.out.println("\nWhich type of account would you like to create?");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Premium Account");
        System.out.print("Choose an option: ");

        int accountOption = input.nextInt();
        switch (accountOption) {
            case 1:
                System.out.println("Enter name for new account");
                String name = input.next();
                accounts[0][index[0]] = new CurrentAccount(String.format("%04d", accountIDcounter), name);
                System.out.println("Created Current account" );
                System.out.print(accounts[0][index[0]]);
                index[0]++;
                accountIDcounter++;
                break;
            case 2:
                System.out.println("Enter name for new account");
                name = input.next();
                accounts[1][index[1]] = new SavingsAccount(String.format("%04d", accountIDcounter), name);
                System.out.println("Created Savings account");
                System.out.println(accounts[1][index[1]]);
                index[1]++;
                accountIDcounter++;
                break;
            case 3:
                System.out.println("Enter name for new account");
                name = input.next();
                accounts[2][index[2]] = new PremiumAccount(String.format("%04d", accountIDcounter), name);
                System.out.println("Created Premium account");
                System.out.println(accounts[2][index[2]]);
                index[2]++;
                accountIDcounter++;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    public void performDebit() {
        input.nextLine();
        System.out.println("Enter account ID: ");
        String accountID = input.nextLine();
        Account account = findAccountById(accountID);
        if (account != null) {
            System.out.println("Enter amount to debit: ");
            double amount = input.nextDouble();
            account.debit(amount);
            System.out.println("Debit successful");
            System.out.println(account);
        }
        else{
            System.out.println("Account not found");
        }
    }
    public void performCredit() {
        input.nextLine();
        System.out.println("Enter account ID: ");
        String accountID = input.nextLine();
        Account account = findAccountById(accountID);
        if (account != null) {
            System.out.println("Enter amount to credit: ");
            double amount = input.nextDouble();
            account.credit(amount);
            System.out.println("Credit successful");
            System.out.println(account);
        }
        else{
            System.out.println("Account not found");
        }
    }

    public void makeTransfer() {
        input.nextLine();
        System.out.println("Enter source account ID: ");
        String sourceAccountID = input.nextLine();
        Account sourceAccount = findAccountById(sourceAccountID);

        System.out.println("Enter destination account ID: ");
        String destinationAccountID = input.nextLine();
        Account destinationAccount = findAccountById(destinationAccountID);

        if(sourceAccount != null && destinationAccount != null) {
            System.out.println("Enter amount to transfer: ");
            double amount = input.nextDouble();
            sourceAccount.transferTo(destinationAccount, amount);
            System.out.println("Source Account -> "+sourceAccount);
            System.out.println("Destination Account -> "+destinationAccount);
        }
        else {
            System.out.println("One or both Invalid account ID");
        }
    }

    public void showBalanceSheet(){
        System.out.println("\nCurrentAccountID\tName\tBalance: ");
        for(int i=0; i<index[0]; i++){
            System.out.println("\t"+accounts[0][i].getId()+"\t\t\t"+accounts[0][i].getName()+"\t"+accounts[0][i].getBalance());
        }
        System.out.println("SavingsAccountID\tName\tBalance: ");
        for(int i=0; i<index[1]; i++){
            System.out.println("\t"+accounts[1][i].getId()+"\t\t\t"+accounts[1][i].getName()+"\t"+accounts[1][i].getBalance());
        }
        System.out.println("PremiumAccountID\tName\tBalance: ");
        for(int i=0; i<index[2]; i++){
            System.out.println("\t"+accounts[2][i].getId()+"\t\t\t"+accounts[2][i].getName()+"\t"+accounts[2][i].getBalance());
        }
    }

    public void run(){
        boolean running = true;
        while(running) {
            showMenu();
            int option;
            option = input.nextInt();
            switch(option){
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDebit();
                    break;
                case 3:
                    performCredit();
                    break;
                case 4:
                    makeTransfer();
                    break;
                case 5:
                    showBalanceSheet();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

