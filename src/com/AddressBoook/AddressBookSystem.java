package com.AddressBoook;
import java.util.*;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap;
    private List<Contact> contactList;
    private Map<String, List<Contact>> cityToPersonsMap;
    private Map<String, List<Contact>> stateToPersonsMap;



    public AddressBookSystem() {
        this.addressBookMap = new HashMap<>();
        this.contactList = new ArrayList<>();
        this.cityToPersonsMap = new HashMap<>();
        this.stateToPersonsMap = new HashMap<>();
    }


    public void addAddressBook(String name) {

        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book with this name already exists.");
        } else {
            AddressBook newBook = new AddressBook(this);
            addressBookMap.put(name, newBook);
            System.out.println("Address Book added successfully: " + name);
        }
    }

    public void addToGlobalList(Contact contact) {
        contactList.add(contact);
        updateCityAndStateMaps(contact);
    }

    private void updateCityAndStateMaps(Contact contact) {
        cityToPersonsMap.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
        stateToPersonsMap.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
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



    private void displayPersonsByCity(String city) {
        List<Contact> contacts = cityToPersonsMap.getOrDefault(city, new ArrayList<>());
        if (contacts.isEmpty()) {
            System.out.println("No persons found in city: " + city);
        } else {
            System.out.println("Persons in city " + city + ":");
            contacts.forEach(Contact::displayContact);
        }
    }

    private void displayPersonsByState(String state) {
        List<Contact> contacts = stateToPersonsMap.getOrDefault(state, new ArrayList<>());
        if (contacts.isEmpty()) {
            System.out.println("No persons found in state: " + state);
        } else {
            System.out.println("Persons in state " + state + ":");
            contacts.forEach(Contact::displayContact);
        }
    }


}