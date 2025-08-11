package com.careerit.jfs.cj.members;

import java.util.Scanner;

public class MemberClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberContainer container = new MemberContainer();

        while (true) {
            System.out.println("\n1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. Search By ID");
            System.out.println("4. Search By Name or ID");
            System.out.println("5. Display Sorting Order");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Country: ");
                    String country = scanner.nextLine();
                    container.addMember(name, city, country);
                    break;
                case 2:
                    System.out.print("Enter Member ID to delete: ");
                    String delId = scanner.nextLine();
                    container.deleteMember(delId);
                    break;
                case 3:
                    System.out.print("Enter Member ID to search: ");
                    String searchId = scanner.nextLine();
                    container.searchById(searchId);
                    break;
                case 4:
                    System.out.print("Enter Member ID (or press Enter to skip): ");
                    String sid = scanner.nextLine();
                    System.out.print("Enter Name (or press Enter to skip): ");
                    String sname = scanner.nextLine();
                    container.searchMember(sid, sname);
                    break;
                case 5:
                    System.out.print("Enter order (Asc/Desc): ");
                    String order = scanner.nextLine();
                    container.displaySortingOrder(order);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

