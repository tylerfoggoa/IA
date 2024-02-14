import java.util.*;
import java.io.*;

public class login {
    public static void main(String[] args) {
        boolean login = false;
        // declaring an array that will store user information
        ArrayList<String> userInfo = new ArrayList<String>();
        // automatically assume the login went well until contradiction 
        login = true;

        // record user info variables
        String email;
        Scanner scan1 = new Scanner(System.in);
        System.out.print("What is your email?: ");
        email = scan1.nextLine();
        userInfo.add(email);

        String name;
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name?: ");
        name = scan.nextLine();
        userInfo.add(name);

        String password;
        Scanner scan2 = new Scanner(System.in);
        System.out.print("What is your password?: ");
        password = scan2.nextLine(); 
        userInfo.add(password);
        try {
            File userInfoFile = new File("C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt");
            Scanner myReader = new Scanner(userInfoFile);
            String nextLine;
            while (myReader.hasNextLine()) {
                // modifying string to be read
                nextLine = myReader.nextLine(); // Create variable to store the next line as a string
                String emailString = nextLine.split(",")[0]; // delete everything after the comma
                if(emailString.equals(email)) { // check to see if the email is already in the array
                    // load user data this would be a SpringBoot controller.  
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
