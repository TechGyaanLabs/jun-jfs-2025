package com.careerit.jfs.cj.day7;

public class AccountManager {

    public static void main(String[] args) {

        Account acc1 = new Account("12345", "John Doe", 1000.0);
        Account acc2 = new Account("67890", "Krish T", 5000.0);
        Account acc3 = new Account("98765", "Haadhya A", 2000.0);


        acc1.showDetails();
        System.out.println("-------------------------");
        acc2.showDetails();
        System.out.println("-------------------------");
        acc3.showDetails();

        acc1.deposit(500.0);
        acc2.withdraw(1000.0);
        acc3.deposit(2000.0);
        System.out.println("After transactions: ");
        acc1.showDetails();
        System.out.println("-------------------------");
        acc2.showDetails();
        System.out.println("-------------------------");
        acc3.showDetails();

    }
}
