import java.io.*;
import java.util.Scanner;

public class RentalManager {
    public static void rentCars(String username) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader("cars.csv"))) {
            String line;
            // Skip the header line
            br.readLine();
            System.out.println("Available cars for rent:");
            while ((line = br.readLine()) != null) {
                String[] carData = line.split(",");
                if (carData.length >= 2) {
                    String carName = carData[0];
                    double price = Double.parseDouble(carData[1]);
                    System.out.println(carName + " - $" + price + " per day");
                }
            }

            System.out.print("Enter the name of the car you want to rent (or type 'exit' to log out): ");
            String selectedCar = scanner.nextLine();
            if (!selectedCar.equals("exit")) {
                System.out.print("Enter the number of days you want to rent the car: ");
                int rentalDays = scanner.nextInt();
                double totalCost = calculateRentalCost(selectedCar, rentalDays);
                System.out.println("You have rented the " + selectedCar + " for " + rentalDays + " days.");
                System.out.println("Total cost: $" + totalCost);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double calculateRentalCost(String carName, int rentalDays) {
        try (BufferedReader br = new BufferedReader(new FileReader("cars.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] carData = line.split(",");
                if (carData.length >= 2 && carData[0].equals(carName)) {
                    double pricePerDay = Double.parseDouble(carData[1]);
                    return pricePerDay * rentalDays;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0.0;
    }
}
