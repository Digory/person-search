package personsearch;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Database { 

    private final List<Person> people = new ArrayList<>();

    public void addNAMENUM(String name, String number) {
        if (!search(name)) {
            Person person = new Person(name);
            people.add(person);
        }
        for (Person elements : people) {
            if (elements.getName().equalsIgnoreCase(name)) {
                elements.addNumber(number);
            }
        }
    }

    public void addPerson(Person person) {
        people.add(person);
    }


    public boolean search(String name) {
        for (Person elements : people) {
            if (elements.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addAddress(String name, String address) {
        for (Person elements : people) {
            if (elements.getName().equals(name)) {
                elements.addAddress(address);
            }
        }
    }

    public Person getPerson(String name) {
        for (Person elements : people) {
            if (elements.getName().equals(name)) {
                return elements;
            }
        }
        return null;
    }

    public String searchName(String name) {
        for (Person elements : people) {
            if (elements.getName().equalsIgnoreCase(name)) {
                return elements.getNumbersAsString();
            }
        }
        return " not found";
    }

    public String searchNumber(String number) {
        for (Person elements : people) {
            if (elements.getNumbers().contains(number)) {
                return elements.getName();
            }
        }
        return " not found";
    }

    public void delete(Person person) {
        people.remove(person);
        
    }

    /* This method searches all data held for a specific keyword, and returns
    the result. If the user inputs an empty space then all data is shown.
    */
    public String listing(String keyword) {
        Collections.sort(people);
        String result = "";
        if (keyword.isEmpty()) {
            for (Person elements : people) {
                result += elements.toString();
               
            }
            return result;
        }
        
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().contains(keyword) || people.get(i).getNumbers().contains(keyword)
                    || people.get(i).getAddressesAsString().contains(keyword)) {
                result += people.get(i).toString();
            }
        }
        if (result.isEmpty()){
            return " not found";
        }
        return result;
    }

}
