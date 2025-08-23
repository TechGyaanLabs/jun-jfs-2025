package com.careerit.jfs.cj.jdbc.assignment;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactDao contactDao = new ContactDaoImpl();
        ContactService contactService = new ContactServiceImpl(contactDao);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Contact Manager ===");
            System.out.println("1. Create Contact");
            System.out.println("2. Get Contact By Id");
            System.out.println("3. Get All Contacts");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Search Contact By Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine();
                    Contact contact = Contact.builder()
                            .name(name)
                            .email(email)
                            .mobile(mobile)
                            .deleted(false)
                            .build();
                    try {
                        contactService.createContact(contact);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter contact ID: ");
                    long id = sc.nextLong();
                    Optional<Contact> contact = contactService.getContactById(id);
                    contact.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("No contact found with id: " + id));
                }
                case 3 -> {
                    List<Contact> contacts = contactService.getAllContacts();
                    contacts.forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("Enter contact ID to update: ");
                    long id = sc.nextLong();
                    sc.nextLine();
                    Optional<Contact> existing = contactService.getContactById(id);
                    if (existing.isPresent()) {
                        System.out.print("Enter new name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter new mobile: ");
                        String mobile = sc.nextLine();
                        Contact updated = existing.get();
                        updated.setName(name);
                        updated.setEmail(email);
                        updated.setMobile(mobile);
                        contactService.updateContact(updated);
                        System.out.println("Contact updated.");
                    } else {
                        System.out.println("No contact found with id: " + id);
                    }
                }
                case 5 -> {
                    System.out.print("Enter contact ID to delete: ");
                    long id = sc.nextLong();
                    boolean deleted = contactService.deleteContact(id);
                    System.out.println(deleted ? "Contact deleted." : "Contact not found.");
                }
                case 6 -> {
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    List<Contact> results = contactService.searchContactsByName(name);
                    results.forEach(System.out::println);
                }
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
