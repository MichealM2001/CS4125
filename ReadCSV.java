import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadCSV {
    public static void main(String[] args) {
        String fileName = "AddCar.csv"; // Creating the name of the CSV file
        readCSVFile(fileName); //Calling the function that reads AddCar.csv
    }

    private static void readCSVFile(String filename){ //Creating function to read CSV file with data of cars
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){ // Close after we read from CSV file. BufferedReader doesn't take in file name, so we pass FileReader which does take file name.
            String line = "";
            
            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace(); // Gives more information about exception if file not found
        } catch (IOException e){ //Try statement closes buffered reader, so this is for in case file cannot be closed
            System.out.println("File could not be closed");
            e.printStackTrace(); //More info
        }
    }
}
