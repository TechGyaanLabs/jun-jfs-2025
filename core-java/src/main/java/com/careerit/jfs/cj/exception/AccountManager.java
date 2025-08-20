package com.careerit.jfs.cj.exception;

public class AccountManager {

    public static void main(String[] args) {

        Account acc1 = new Account("12345", "John Doe", 1000.0);
        acc1.showDetails();

        try{
            acc1.withdraw(2000.0);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }

        acc1.deposit(5000.0);
        acc1.showDetails();
    }
}
