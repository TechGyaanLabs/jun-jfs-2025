package com.careerit.jfs.cj.day7;

public class Account {

    private String accNum;
    private String name;
    private double balance;

    public Account(String accNum, String name, double balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully and current balance is: " + balance);
    }

    public void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully and current balance is: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void showDetails() {
        System.out.println("Account number: " + accNum);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}
