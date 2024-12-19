package com.AddressBoook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AddressBook {
    private List<Contact> contactList;

    public AddressBook() {
        this.contactList = new ArrayList<>();
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        String addAnother = "Y";

        do {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter State: ");
            String state = scanner.nextLine();

            System.out.print("Enter Zip: ");
            String zip = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
            contactList.add(contact);
            System.out.println("Contact added successfully.");

            System.out.print("Do you want to add another contact? [Y/N]: ");
            addAnother = scanner.nextLine().toUpperCase();
        } while (addAnother.equals("Y"));

        System.out.println("Returning to the main menu.");
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

        public void editContact() {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the First Name of the contact to edit:");
                String firstName = scanner.nextLine();
                System.out.println("Enter the Last Name of the contact to edit:");
                String lastName = scanner.nextLine();

                for (Contact contact : contactList) {
                    if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                        System.out.println("Contact found. Enter new details:");

                        System.out.println("Enter New Address:");
                        String address = scanner.nextLine();
                        System.out.println("Enter New City:");
                        String city = scanner.nextLine();
                        System.out.println("Enter New State:");
                        String state = scanner.nextLine();
                        System.out.println("Enter New Zip:");
                        String zip = scanner.nextLine();
                        System.out.println("Enter New Phone Number:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter New Email:");
                        String email = scanner.nextLine();

                        contact.updateContactDetails(address, city, state, zip, phoneNumber, email);
                        System.out.println("Contact updated successfully.");
                        return;
                    }
                }
                System.out.println("Contact not found.");
    }


    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the First Name of the contact to delete:");
        String firstName = scanner.nextLine();
        System.out.println("Enter the Last Name of the contact to delete:");
        String lastName = scanner.nextLine();

        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                contactList.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }


//    public void addMultipleContacts()
//    {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("How Many Contacts Do you Want to Add ?");
//        int numberOfContacts = sc.nextInt();
//
//        for(int i =0;i<numberOfContacts;i++)
//        {
//            System.out.println("Adding Contact"+(i+1)+":");
//            addContact();
//        }
//        System.out.println("All Contacts Added Successfully");
//    }


}
