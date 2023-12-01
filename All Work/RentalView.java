import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class RentalView {
    private static final String CAR_CSV_FILE_PATH = "cars.csv";
    public static void displayAvailableCars(List<RentalModel> cars) {
        System.out.println("Available cars for rent:");
        for (RentalModel car : cars) {
            System.out.println(car.getCarName() + " - $" + car.getPricePerDay() +
                    " per day, Availability: " + car.getAvailability());
        }
    }

    // Add a new method to update the availability
    public static void displayUpdatedAvailability(RentalModel car) {
        System.out.println("Availability decreased. New availability for " + car.getCarName() +
                ": " + car.getAvailability());
    }

    public static void displayRentalDetails(String selectedCar, int rentalDays, double totalCost) {
        System.out.println("You have rented the " + selectedCar + " for " + rentalDays + " days.");
        System.out.println("Total cost: $" + totalCost);
    }

    public static void saveCarsToCsv(List<RentalModel> cars) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAR_CSV_FILE_PATH))) {
            // Write header
            writer.println("CarName,pricePerDay,availability");

            // Write data
            for (RentalModel car : cars) {
                writer.println(car.getCarName() + "," + car.getPricePerDay() + "," + car.getAvailability());
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}

