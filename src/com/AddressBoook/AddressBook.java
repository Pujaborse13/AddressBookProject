package com.AddressBoook;

import java.util.*;

class AddressBook {

    private List<Contact> contactList;
    private AddressBookSystem addressBookSystem;

    private Map<String, List<Contact>> cityMap;
    private Map<String, List<Contact>> stateMap;

    public AddressBook(AddressBookSystem system) {
        this.contactList = new ArrayList<>();
        this.addressBookSystem = system;

        this.cityMap = new HashMap<>();
        this.stateMap = new HashMap<>();
    }



    public void addContact() {

        Scanner scanner = new Scanner(System.in);
        String addAnother = "Y";

        do {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();


            boolean isDuplicate = contactList.stream()
                            .anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName)
                            && contact.getLastName().equalsIgnoreCase(lastName));

            if (isDuplicate) {
                System.out.println("Contact with this name already exists. Cannot add duplicate.");
                return;

            }


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
            addressBookSystem.addToGlobalList(contact);


            cityMap.computeIfAbsent(city, k -> new ArrayList<>()).add(contact);
            stateMap.computeIfAbsent(state, k -> new ArrayList<>()).add(contact);

            System.out.println("Contact added successfully.");

            System.out.print("Do you want to add another contact? [Y/N]: ");
            addAnother = scanner.nextLine().toUpperCase();
        }

        while (addAnother.equals("Y"));
        System.out.println("Returning to the main menu.");
    }

    /*public List<Contact> getContactList() {
        return contactList;
    }*/

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


    public void searchPersonInCityOrState() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by: 1. City  2. State");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the city or state: ");
        String location = scanner.nextLine().trim();

        List<Contact> result = new ArrayList<>();

        if (choice == 1) {
            // Fetch contacts from city map
            result = cityMap.getOrDefault(location, new ArrayList<>());
        } else if (choice == 2) {
            // Fetch contacts from state map
            result = stateMap.getOrDefault(location, new ArrayList<>());
        }

        if (result.isEmpty()) {
            System.out.println("No contacts found in the specified city or state: " + location);
        } else {
            System.out.println("Contacts found in the specified city or state: " + location);
            result.forEach(Contact::displayContact);
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

}


