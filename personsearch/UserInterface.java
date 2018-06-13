package personsearch;

import java.util.Scanner;

public class UserInterface { 

    private final Database myDatabase = new Database();
    private final Scanner reader;

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        initialDisplay();
        obtainInput();
    }

    public void initialDisplay() { 
        System.out.println("phone search\navailable operations:");
        System.out.println(" 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n");
    }

    public void obtainInput() {
        boolean keepAsking = true;
        while (keepAsking) {
            System.out.print("command: ");
            String command = reader.nextLine();
            
            switch (command) {
                case "x": {
                    keepAsking = false;
                    break;
                }
                case "1": {
                    addNumber();
                    break;
                }
                case "2": {
                    searchForNumber();
                    break;
                }
                case "3": {
                    searchForPersonByNumber();
                    break;
                }
                case "4": {
                    addAnAddress();
                    break;
                }
                case "5": {
                    searchForInfo();
                    break;
                }
                case "6": {
                    deleteInfo();
                    break;
                }
                case "7": {
                    filteredListing();
                    break;
                } 
            } 
        }
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        myDatabase.addNAMENUM(name, number);
    }

    public boolean personAlreadyThere(String name) {
        return myDatabase.search(name);
    }

    public void searchForNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.println(myDatabase.searchName(name));
    }

    public void searchForPersonByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();
        System.out.println(myDatabase.searchNumber(number));
    }

    public void addAnAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        String address = street + "\n" + city;
        if (personAlreadyThere(name)) {
            myDatabase.addAddress(name, address);
        } else {
            Person person = new Person(name);
            person.addAddress(address);
            myDatabase.addPerson(person);
        }
    }

    public void searchForInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (!personAlreadyThere(name)) {
            System.out.println(" not found");
            return;
        }
        if (myDatabase.getPerson(name).getAddresses().isEmpty()) {
            System.out.println(" address unknown");
        } else {
            System.out.println(" address: " + myDatabase.getPerson(name).getAddressesAsString());
        }
        if (myDatabase.getPerson(name).getNumbers().isEmpty()) {
            System.out.println(" phone number not found");
        } else {
            System.out.println(" phone numbers:\n" + myDatabase.getPerson(name).getNumbersAsString());
        }

    }

    public void deleteInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (!personAlreadyThere(name)) {
            return;
        }
        while (myDatabase.search(name)) {
            myDatabase.delete(myDatabase.getPerson(name));
        }
    }

    public void filteredListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        System.out.println(myDatabase.listing(keyword));
    }

}
