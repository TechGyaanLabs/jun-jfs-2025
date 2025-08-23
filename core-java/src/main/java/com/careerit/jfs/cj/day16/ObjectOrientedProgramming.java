package com.careerit.jfs.cj.day16;

class Account{
    private String accountNo;
    private String name;
    private double balance;

    public Account(String accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("Balance: " + balance);
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Balance: " + balance);
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
}
public class ObjectOrientedProgramming {

    public static void main(String[] args) {

        Account acc1 = new Account("SB10001", "John Doe", 1000.0);
        Account acc2 = new Account("SB10002", "Krish T", 25000.0);
        Account acc3 = new Account("SB10003", "Manoj PVN", 15000.0);
        Account acc4 = new Account("SB10004", "Balu T", 15000.0);

        // Print Account number - Balance

        Account[] arr = new Account[]{acc1, acc2, acc3, acc4};

        for(Account acc : arr) {
            System.out.println(acc.getAccountNo() + " - " + acc.getBalance());
        }




    }
}
