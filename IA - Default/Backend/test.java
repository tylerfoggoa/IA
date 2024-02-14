import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        // declaring an array that will store user information
        ArrayList<String> userInfo = new ArrayList<String>();
        boolean login = false; // assume login failed until proven otherwise

        // record user info variables
        String email, name, password;
        Scanner scanner = new Scanner(System.in);

        // Collect user information
        System.out.print("What is your email?: ");
        email = scanner.nextLine();
        userInfo.add(email);

        System.out.print("What is your name?: ");
        name = scanner.nextLine();
        userInfo.add(name);

        System.out.print("What is your password?: ");
        password = scanner.nextLine(); 
        userInfo.add(password);

        // Check if the email is already in the system
        if (!isEmailAlreadyRegistered(email)) {
            try {
                // Specify the file path
                String filePath = "C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt";

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
                
                // Set login flag to true if the user is successfully registered
                login = true;
                
                System.out.println("User registered successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing user information to the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Your email is already in the system, please login");
        }

        // You can use the login flag here to perform further actions based on whether the user is logged in or not
    }

    public static boolean isEmailAlreadyRegistered(String email) {
        try {
            File userInfoFile = new File("C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt");
            Scanner myReader = new Scanner(userInfoFile);
            String nextLine;
            while (myReader.hasNextLine()) {
                nextLine = myReader.nextLine();
                String emailString = nextLine.split(",")[0].trim(); // trim to remove leading/trailing spaces
                if (emailString.equals(email)) {
                    myReader.close();
                    return true; // Email found in the file
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading user information from the file.");
            e.printStackTrace();
        }
        return false; // Email not found in the file
    }
}
