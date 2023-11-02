import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CarDatabase {
    public static void main(String[] args) {
        String fileName = "CarDatabase.csv";
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add a car");
            System.out.println("2. Remove a car");
            System.out.println("3. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCar(fileName, scanner);
                    break;
                case 2:
                    removeCar(fileName, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addCar(String fileName, Scanner scanner) {
        int yearOfReg;
        String model;
        System.out.println("Enter year of registration.");
        yearOfReg = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter model of car.");
        model = scanner.nextLine();

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(yearOfReg + "," + model + "\n");
            System.out.println("Car added to the database.");
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
            e.printStackTrace();
        }
    }

    private static void removeCar(String fileName, Scanner scanner) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("TempCarDatabase.csv"); // Use a different temporary filename

            BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            System.out.println("Enter the model of the car to remove:");
            String modelToRemove = scanner.nextLine();
            String currentLine;

            boolean carRemoved = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(modelToRemove)) {
                    carRemoved = true;
                    continue;
                }
                writer.write(currentLine + "\n");
            }

            writer.close();
            reader.close();

            if (carRemoved) {
                inputFile.delete();
                tempFile.renameTo(new File(fileName));
                System.out.println("Car removed from the database.");
            } else {
                tempFile.delete();
                System.out.println("Car not found in the database.");
            }
        } catch (IOException e) {
            System.out.println("Error removing the car from the file.");
            e.printStackTrace();
        }
    }
}
