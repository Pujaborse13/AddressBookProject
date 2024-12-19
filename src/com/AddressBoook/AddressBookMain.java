package com.AddressBoook;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBookSystem addressBookSystem = new AddressBookSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display All Address Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addressBookSystem.addAddressBook();
                    break;

                case 2:
                    System.out.println("Available Address Books : " + addressBookSystem.getAddressBookNames());
                    System.out.print("Enter the name of the Address Book to access : ");
                    String addressBookName = scanner.nextLine();

                    AddressBook selectedAddressBook = addressBookSystem.getAddressBookByName(addressBookName);
                    if (selectedAddressBook == null) {
                        System.out.println("No Address Book found with the name \"" + addressBookName + "\".");
                    } else {
                        manageAddressBook(selectedAddressBook, scanner);
                    }
                    break;


                case 3:
                    addressBookSystem.displayAllAddressBooks();
                    break;

                case 4:
                    System.out.println("Existing Program ");
                    return;

                default:
                    System.out.println("Invalid choice");
            }

        }

    }

        private static void manageAddressBook(AddressBook addressBook, Scanner scanner)
        {
        while (true) {
            System.out.println("\nMenu:");
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
                    System.out.println("Returning to Main menu");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }

    }
}