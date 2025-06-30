package com.careerit.jfs.cj.day15;

class Account{
    private String accountNo;
    private String name;
    private double balance;
    public Account(String accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    public void showDetails() {
        EnrichAccountWithFormattedData enrichAccountWithFormattedData = new EnrichAccountWithFormattedData();
        enrichAccountWithFormattedData.showDetails(this);
        System.out.println("Account No: " + this.accountNo);
        System.out.println("Name: " + this.name);
        System.out.println("Balance: " + this.balance);
    }
}

class EnrichAccountWithFormattedData {

        public void showDetails(Account account) {
            System.out.println("Account No: " + "********" + account.getAccountNo().substring(account.getAccountNo().length() - 4));
            System.out.println("Name: " + account.getName());
            System.out.println("Balance: " + String.format("%.2f",account.getBalance()));
        }
}
public class EnrichObjectWithFormattedData {

    public static void main(String[] args) {
            Account acc1 = new Account("12345345567", "John Doe", 1000.5445f);
            acc1.showDetails();
    }
}
