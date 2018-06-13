package personsearch;
import java.util.*;

public class Person implements Comparable<Person>{
private final String name;
private final Set<String> numbers;
private final Set<String> addresses;

    public Person(String name){
        numbers = new HashSet<>();
        addresses = new HashSet<>();
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public Set<String> getNumbers(){
        if (numbers.isEmpty()){
            Set<String> blank = new HashSet<String>();
            return blank;
        }
        return numbers;
    }
    
    public String getNumbersAsString(){
        String result = "";
        if (numbers.isEmpty()){
            return " not found";
        }
        for (String elements : numbers){
            result += elements+"\n";
        }
        return result;
    }
    
    public String getAddressesAsString(){
        String result = "";
        for (String elements : addresses){
            result += elements+"\n";
        }
        return result;
    }
    
    public Set<String> getAddresses(){
        if (addresses.isEmpty()){
            Set<String> blank = new HashSet<String>();
            return blank;
        }
        return addresses;
    }
    
    public void addNumber(String number){
        numbers.add(number);
    }
    
    public void addAddress(String address){
        addresses.add(address);
    }
    
    @Override
    public String toString(){
        if (addresses.isEmpty()){
         return name+"\n address unknown\n phone number(s): "+getNumbersAsString();
        }
        else if (numbers.isEmpty()){
            return name+"\n address: "+getAddressesAsString()+" phone number not found";
        }
        else {
            return name+"\n address: "+getAddressesAsString()+" phone number(s): "+getNumbersAsString();
        }
         
        
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.codePointAt(0) < person.getName().codePointAt(0)){
            return - 1;
        }
        else if (this.name.codePointAt(0) == person.getName().codePointAt(0)){
            return 0;
        }
        else {
            return 1;
        }
    }
}
