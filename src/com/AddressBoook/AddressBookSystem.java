package com.AddressBoook;
import java.util.*;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap;
    private List<Contact> contactList = new ArrayList<>();

    public AddressBookSystem() {
        this.addressBookMap = new HashMap<>();
        this.contactList = new ArrayList<>();
    }


    public void addAddressBook(String name) {

        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book with this name already exists.");
        } else {
            //addressBookMap.put(name, new AddressBook());
            AddressBook newBook = new AddressBook(this); // Pass system reference
            addressBookMap.put(name, newBook);
            System.out.println("Address Book added successfully: " + name);
        }
    }

    public void addToGlobalList(Contact contact) {
        contactList.add(contact);
    }




    public void selectAddressBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Address Books " + addressBookMap.keySet());
        System.out.println("Enter the name of of Address Book To access :");
        String addressBookName = scanner.next();

        AddressBook selectAddressBook = addressBookMap.get(addressBookName);

        if (selectAddressBook == null) {
            System.out.println("Address Book Not Found with this Name " + addressBookName);
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