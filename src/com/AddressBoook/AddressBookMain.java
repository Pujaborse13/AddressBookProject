package com.AddressBoook;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;


        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");


            System.out.print("Enter your choice: ");
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
                    exit = true;
                    System.out.println("Exiting Address Book Program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");



            }
        }
    }
}