import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class EditCSV {
    public static void main(String[] args) {
        String fileName = "AddCar.csv";
        editCSVFile(fileName);
    }

    private static void editCSVFile(String fileName) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Read the entire CSV file into memory
            File file = new File(fileName); // File object to represent CSV
            BufferedReader br = new BufferedReader(new FileReader(file)); // BufferedReader for reading file
            StringBuilder csvData = new StringBuilder(); // StringBuilder for storing  contents of CSV
            String line;

            while ((line = br.readLine()) != null) { // Read each line from CSV and add to StringBuilder
                csvData.append(line).append("\n");
            }

            System.out.println("Which line would you like to edit? (Enter line number or 0 to exit):"); // Message asking which line user want to edit.
            int lineToEdit = scanner.nextInt();

            if (lineToEdit > 0 && lineToEdit <= csvData.toString().split("\n").length) {
                scanner.nextLine(); // Consume the newline character.
                
                int newYearOfReg; // Declaring a variable that holds car's new year of registration
                String newModel; // Declaring a variable that holds car's new model
                int newPrice; // Declaring a variable that holds car's new price
                String newIsRented; //Declaring a variable that holds car's new rental status
                String newClassification; // Declaring a variable that holds car's classification

                System.out.print("Enter year of registration."); // Message asking user to enter year of car's registration
                newYearOfReg = scanner.nextInt(); // Using input as car's year of registration

                scanner.nextLine(); // Moves to the next line.

                System.out.print("Enter model of car."); // Message asking the user to enter car's model
                newModel = scanner.nextLine(); // Using input as car's model

                System.out.print("Enter price of car"); // Message asking the user to enter car's price
                newPrice = scanner.nextInt(); //Using input as car's price

                scanner.nextLine(); // Moves to the next line.

                System.out.print("Is car rented?"); // Message asking the user to enter car's rental status
                newIsRented = scanner.nextLine(); // Using input as car's rental status

                System.out.print("Enter classification of car."); // Message asking the user to enter car's classification
                newClassification = scanner.nextLine(); // Using input as car's classification

                // Add new details to line.
                String newLine = newYearOfReg + "," + newModel + "," + newPrice + "," + newIsRented + "," + newClassification;

                String[] lines = csvData.toString().split("\n"); // Split data by line
                lines[lineToEdit - 1] = newLine; // Allows user to select line they want to edit with the starting index being 1 instead of 0 like usual

                String updatedCsvData = String.join("\n", lines); // Join lines for updated CSV

                BufferedWriter bw = new BufferedWriter(new FileWriter(file)); // Writes updated data to CSV
                bw.write(updatedCsvData);
                bw.close();

                System.out.println("Line edited successfully.");
            } else {
                System.out.println("No changes made.");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error editing the file.");
            e.printStackTrace();
        }
    }
}
