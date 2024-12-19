package com.AddressBoook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBookSystem {
    private Map<String, AddressBook> addressBookMap;

    public AddressBookSystem() {
        this.addressBookMap = new HashMap<>();
    }


    public void addAddressBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter The Name of New Address Book : ");
        String addressBookName = scanner.next();

        if (addressBookMap.containsKey(addressBookName)) {
            System.out.println("Address Book with this Name Already Exist ");
        } else {
            AddressBook newAddressBook = new AddressBook();
            addressBookMap.put(addressBookName, newAddressBook);
            System.out.println("Address Book Name : " + addressBookName + " Added Successfully");
            System.out.println();
        }
    }


    public void selectAddressBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Address Books " + addressBookMap.keySet());
        System.out.println("Enter the name of of Address Book To access :");
        String addressBookName = scanner.next();

        AddressBook selectAddressBook = addressBookMap.get(addressBookName);

        if (selectAddressBook == null) {
            System.out.println("Address Book Not Found with this Name " + addressBookName);
        } else {
            manageAddressBook(selectAddressBook);

        }

    }

    public void manageAddressBook(AddressBook addressBook) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Go Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.displayAllContacts();
                    break;
                case 3:
                    addressBook.editContact();
                    break;
                case 4:
                    addressBook.deleteContact();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayAllAddressBooks() {
        if (addressBookMap.isEmpty()) {
            System.out.println("No Address Books available.");
        } else {
            System.out.println("\nAddress Books in the system:");
            for (String name : addressBookMap.keySet()) {
                System.out.println("- " + name);
            }
        }
    }


    public AddressBook getAddressBookByName(String name) {
        return addressBookMap.get(name);
    }


    public Set<String> getAddressBookNames() {
        if (addressBookMap.isEmpty()) {
            System.out.println("No Address Books available.");
        }
        return addressBookMap.keySet();
    }


}