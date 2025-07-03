package com.careerit.jfs.cj.day16;


class GeneralAccount {
    protected String accountNo;
    protected String name;
    protected double balance;

    public GeneralAccount(String accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
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
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends GeneralAccount {
    private double minBalance;

    public SavingsAccount(String accountNo, String name, double balance, double minBalance) {
        super(accountNo, name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount) {
        if(amount > balance - minBalance) {
           if(amount > balance) {
               System.out.println("Insufficient balance");
           }else{
               System.out.println("Minimum balance should be maintained");
           }
        }else{
            balance = balance - amount;
            System.out.println("After withdrawal of " + amount + " balance is " + balance);
        }
    }
}

class CurrentAccount extends GeneralAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNo, String name, double balance, double overdraftLimit) {
        super(accountNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount) {

        if(amount > balance + overdraftLimit) {
            System.out.println("Insufficient balance");
        }else{
            if(amount > balance) {
                double total = balance + overdraftLimit;
                double overdraft = total - amount;
                System.out.println("You are trying to withdraw amount from overdraft limit and you are left with overdraft amount is : "+ overdraft);
            }
            balance = balance - amount;
            System.out.println("After withdrawal of " + amount + " balance is " + balance);
        }

    }
}

public class InheritanceExample2 {

    public static void main(String[] args) {

        GeneralAccount acc1 = new SavingsAccount("SB10001", "John Doe", 1000.0, 500.0);
        GeneralAccount acc2 = new CurrentAccount("SB10002", "John Industries", 25000.0, 5000.0);

        acc1.showDetails();
        acc2.showDetails();

        acc1.deposit(1000.0);
        acc2.deposit(5000.0);

        acc1.withdraw(2000.0);
        acc2.withdraw(32000);

        System.out.println("\n\n");
        acc1.showDetails();
        acc2.showDetails();
    }
}
