import personsearch.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*String input = "1\n"+"peter\n"+"040-123456\n"+"2\n"+"jane\n"
                +"2\n"+"peter\n"+"1\n"+"peter\n"+
                "09-222333\n"+"2\n"+"peter\n"+"3\n"+"02-444123\n"+
                "3\n"+"09-222333\n"+"5\n"+"peter\n"+"\n"+"x"+"\n"; */
        // ^Use the above for testing.
        
        Scanner reader = new Scanner(System.in);
        UserInterface obj = new UserInterface(reader);
        obj.start();
        
}
}
