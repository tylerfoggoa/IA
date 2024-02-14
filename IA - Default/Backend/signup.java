import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class signup {
    public static void main(String[] args) {
        boolean login = false;
        // declaring an array that will store user information
        ArrayList<String> userInfo = new ArrayList<String>();
        // automatically assume the login went well until ReadFile contradicts 
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
                    System.out.println("Your email is already in the system, please login");
                    login = false;
                    // clearing temp arraylist when account creation fails to accept new info
                    userInfo.clear();
                }
            }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Specify the file path
        String filePath = "C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt";

        try {
            // Create FileWriter and BufferedWriter objects
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Write each element of the userInfo ArrayList to the file
            for (String info : userInfo) {
                bufferedWriter.write(info);
                bufferedWriter.write(", ");
            }
            bufferedWriter.newLine(); // Add a new line after each set of info stored in the array 

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing user information to the file.");
            e.printStackTrace();
        }
    }

    public static void ReadFile(String email, boolean login, ArrayList userInfo) {
        try {
            File userInfoFile = new File("C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt");
            Scanner myReader = new Scanner(userInfoFile);
            String nextLine;
            while (myReader.hasNextLine()) {
                // modifying string to be read
                nextLine = myReader.nextLine(); // Create variable to store the next line as a string
                String emailString = nextLine.split(",")[0]; // delete everything after the comma
                if(emailString == email) { // check to see if the email is already in the array
                    System.out.println("Your email is already in the system, please login");
                    login = false;
                    // clearing temp arraylist when account creation fails to accept new info
                    userInfo.clear();
                }
            }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
