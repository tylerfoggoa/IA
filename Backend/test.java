/*
    test to see if i can make my own database code in about 60 mins. 
    list will eventually become the backend for the signup page
*/ 

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        boolean login = false;
        // declaring an array that will store user information
        ArrayList<String> userInfo = new ArrayList<String>();


        // loop that ensures the user is able to login
        while(login == false) {
            // record some variables
            String name;
            Scanner scan = new Scanner(System.in);
            System.out.print("What is your name?: ");
            name = scan.nextLine();
            userInfo.add(name);

            String email;
            Scanner scan1 = new Scanner(System.in);
            System.out.print("What is your email?: ");
            email = scan.nextLine();
            userInfo.add(email);

            String password;
            Scanner scan2 = new Scanner(System.in);
            System.out.print("What is your password?: ");
            password = scan.nextLine(); 
            userInfo.add(password);

            // assume the login went well until ReadFile verifies
            login = true;

            // check to see if the email is already registered
            ReadFile(email, login, userInfo);
        }

        // Specify the file path
        String filePath = "C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt";

        try {
            // Create FileWriter and BufferedWriter objects
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // starting with an offset to avoid overwriting data
            for(int i = 0; i > offset; i++) {
                bufferedWriter.write("\n");
            }

            // Write each element of the userInfo ArrayList to the file
            for (String info : userInfo) {
                bufferedWriter.write(info);
                bufferedWriter.newLine(); // Add a new line after each element
            }

            // Close the BufferedWriter
            bufferedWriter.close();

            System.out.println("User information has been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing user information to the file.");
            e.printStackTrace();
        }
    }




    public static void ReadFile(String email, boolean login, ArrayList userInfo) {
        try {
            File userInfoFile = new File("C:\\Users\\foggtyl25\\OneDrive - issaquah.wednet.edu\\IB Comp Sci\\IA\\Stored Data\\userlist.txt");
            Scanner myReader = new Scanner(userInfoFile);
            while (myReader.hasNextLine()) {
                if(myReader.nextLine() == email) {
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

    public static void getOffset
}


// TODO
    // fix overwriting userlist
        // finish getOffset method and put it in the writer method
    // document file search code