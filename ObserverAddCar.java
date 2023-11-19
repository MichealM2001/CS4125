import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observer interface
interface CarAddedObserver {
    void onCarAdded(String carDetails);
}

// Concrete Observer
class CarAddedObserverImpl implements CarAddedObserver {
    @Override
    public void onCarAdded(String carDetails) {
        System.out.println("Observer: Car added - " + carDetails);
    }
}

// Subject class
class CarSubject {
    private List<CarAddedObserver> observers = new ArrayList<>();

    public void addObserver(CarAddedObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CarAddedObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String carDetails) {
        for (CarAddedObserver observer : observers) {
            observer.onCarAdded(carDetails);
        }
    }
}

public class ObserverAddCar {
    public static void main(String[] args) {
        String fileName = "AddCar.csv";
        Scanner scanner = new Scanner(System.in);
        CarSubject carSubject = new CarSubject();
        CarAddedObserver observer = new CarAddedObserverImpl();
        carSubject.addObserver(observer);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add a car");
            System.out.println("2. Remove a car");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                writeToCSVFile(fileName, scanner, carSubject);
            } else if (choice == 2) {
                removeCarFromCSV(fileName, scanner);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void writeToCSVFile(String fileName, Scanner scanner, CarSubject carSubject) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            System.out.println("Enter year of registration:");
            int yearOfReg = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter model of car:");
            String model = scanner.nextLine();

            System.out.println("Enter price of car:");
            int price = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Is car rented? (yes or no):");
            String isRented = scanner.nextLine().toLowerCase();

            System.out.println("Enter classification of car:");
            String classification = scanner.nextLine();

            fw.write(yearOfReg + "," + model + "," + price + "," + isRented + "," + classification + "\n");
            System.out.println("Car details added to the CSV.");
            
            // Notify observers that a car has been added
            carSubject.notifyObservers("Year: " + yearOfReg + ", Model: " + model + ", Price: " + price +
                    ", Rented: " + isRented + ", Classification: " + classification);
        } catch (IOException e) {
            System.out.println("Error creating/writing to the file.");
            e.printStackTrace();
        }
    }

    private static void removeCarFromCSV(String fileName, Scanner scanner) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp.csv");

            if (!inputFile.exists()) {
                System.out.println("File not found.");
                return;
            }

            // Prompt the user for the car model to remove
            System.out.println("Enter the model of the car to remove:");
            String carModelToRemove = scanner.nextLine();

            Scanner fileScanner = new Scanner(inputFile);
            FileWriter fw = new FileWriter(tempFile, true);

            // Iterate through the lines in the input CSV file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                // Check if the line contains at least two parts and if the car model matches
                if (parts.length >= 2 && !parts[1].equalsIgnoreCase(carModelToRemove)) {
                    fw.write(line + "\n"); // Write the line to the temporary file
                }
            }

            fileScanner.close();
            fw.close();

            // Replace the original CSV file with the temporary file
            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                System.out.println("Car removed from the CSV.");
            } else {
                System.out.println("Failed to remove car.");
            }
        } catch (IOException e) {
            System.out.println("Error reading/writing to the file.");
            e.printStackTrace();
        }
    }
}
