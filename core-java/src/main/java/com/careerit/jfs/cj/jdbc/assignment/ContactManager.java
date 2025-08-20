package com.careerit.jfs.cj.jdbc.assignment;

import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {

            ContactDao contactDao = new ContactDaoImpl();
            ContactService contactService = new ContactServiceImpl(contactDao);
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1. Create Contact");
                System.out.println("2. Get Contact By Id");
                System.out.println("3. Get All Contacts");
                System.out.println("4. Update Contact");
                System.out.println("5. Delete Contact");
                System.out.println("6. Search Contact By Name");
                System.out.println("7. Exit");
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter name: ");
                        String name = sc.next();
                        System.out.println("Enter email: ");
                        String email = sc.next();
                        System.out.println("Enter phone: ");
                        String phone = sc.next();
                        Contact contact = new Contact();
                        contact.setName(name);
                        contact.setEmail(email);
                        contact.setMobile(phone);
                        try {
                            contactService.createContact(contact);
                        }catch (Exception e) {
                            System.out.println("Adding contact is failed " + e);
                        }
                        break;
                }
            }
    }
}
