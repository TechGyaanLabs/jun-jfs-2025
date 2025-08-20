package com.careerit.jfs.cj.exception;

public class Account {

    private String accountNumber;
    private String name;
    private double balance;

    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("After withdrawal of " + amount + " balance is " + balance);
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("After deposit of " + amount + " balance is " + balance);
    }

    public void showDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}
