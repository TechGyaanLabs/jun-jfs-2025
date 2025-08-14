package HomeWork;

import java.util.Scanner;

public class PhoneBookManager {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====Phone Book Menu ===");
            System.out.println("\n1. Add new phone book entry");
            System.out.println("2. Search name");
            System.out.println("3. Quit ");
            System.out.println("Enter the choice");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Phone Number : ");
                    String phoneno = sc.nextLine();
                    System.out.println("Enter Name : ");
                    String name = sc.nextLine();
                    phoneBook.addDetails(phoneno, name);
                    break;

                case 2:
                    System.out.println("Enter phone number to search: ");
                    String searchPhone = sc.nextLine();
                    System.out.println("Result: " + phoneBook.getName(searchPhone));
                    break;

                case 3:
                    System.out.println("quited from phoneBook ");
                    return;

                default:
                    System.out.println("Invalid choice! please try again");

            }
        }
    }

}
