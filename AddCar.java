import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddCar {
    public static void main(String[] args) {
        String fileName = "AddCar.csv"; // Creating the name of the CSV file
        writeToCSVFile(fileName); // Calling the function that writes to AddCar.csv
    }

    private static void writeToCSVFile(String fileName) {
        Scanner scanner = new Scanner(System.in); // Initializing a scanner to take input from the user

        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.write("Year of registration" + "," + "Car model\n"); // First row of text in CSV indicating what each column means
            
            while (true) { //Starts loops without an actual condition. Just assumes it to be true to start loop
                int yearOfReg; // Declaring a variable that holds car's year of registration
                String model; // Declaring a variable that holds car's model

                System.out.println("Enter year of registration."); // Message asking user to enter year of car's registration
                yearOfReg = scanner.nextInt(); // Using input as car's year of registration
                
                scanner.nextLine(); // Moves to next line

                System.out.println("Enter model of car."); // Message asking the user to enter car's model
                model = scanner.nextLine(); // Using input as car's model

                pw.write(yearOfReg + "," + model + "\n"); // Writing values taken from user input into CSV

                System.out.println("Car details added to the CSV."); //Confirms that details have been added to CSV
                System.out.println("Do you want to add another car? (Type 'yes' or 'no')");
                
                String response = scanner.nextLine().toLowerCase(); //Takes user's response and converts text to lower case so that response is not case sensitive
                if (!response.equals("yes")) {
                    break; // Exits the loop if user is done.
                }
            }

            System.out.println("Finished writing to file"); // Final message
        } catch (FileNotFoundException e) {
            System.out.println("Error creating/writing to the file.");
            e.printStackTrace();
        }
    }
}