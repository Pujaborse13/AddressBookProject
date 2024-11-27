package com.AddressBoook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AddressBook {
    private List<Contact> contactList;

    public AddressBook() {
        this.contactList = new ArrayList<>();
    }

    // Add a new contact to the address book
    public void addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter City:");
        String city = scanner.nextLine();
        System.out.println("Enter State:");
        String state = scanner.nextLine();
        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();


        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }


    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            System.out.println("\nAddress Book Contacts:");
            for (Contact contact : contactList) {
                contact.displayContact();
                System.out.println("--------------------------");
            }
        }
    }
}
