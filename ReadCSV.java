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
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = "";
            
            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("File could not be closed");
            e.printStackTrace();
        }
    }
}