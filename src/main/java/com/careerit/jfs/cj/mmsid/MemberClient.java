package com.careerit.jfs.cj.mmsid;

import java.util.Scanner;

public class MemberClient {
    public static void main(String[] args) {
        MemberContainer container = new MemberContainer();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Member Menu ===");
            System.out.println("1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. Search By ID");
            System.out.println("4. Search By Name or ID");
            System.out.println("5. Display Sorting Order");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter Country: ");
                    String country = sc.nextLine();
                    container.addMember(name, city, country);
                    break;

                case 2:
                    System.out.print("Enter Member ID to delete: ");
                    String delId = sc.nextLine();
                    container.deleteMember(delId);
                    break;

                case 3:
                    System.out.print("Enter Member ID to search: ");
                    String searchId = sc.nextLine();
                    container.searchById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    String sid = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();
                    container.searchMember(sid, sname);
                    break;

                case 5:
                    System.out.print("Enter order (Asc/Desc): ");
                    String order = sc.nextLine();
                    container.displaySortingOrder(order);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
