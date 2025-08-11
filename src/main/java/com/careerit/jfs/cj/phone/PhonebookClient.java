package com.careerit.jfs.cj.phone;

import java.util.Scanner;

public class PhonebookClient {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Add new phone book entry");
            System.out.println("2. Search name by phone number");
            System.out.println("3. Quit");
            System.out.print("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter phone number: ");
                    String phno = scanner.nextLine();

                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    PhoneBook.addDetails(phno, name);
                    break;

                case 2:
                    System.out.print("Enter phone number to search: ");
                    String searchphno = scanner.nextLine();
                    System.out.println(phoneBook.getName(searchphno));
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice please try again.");
            }
        }

    }
}
