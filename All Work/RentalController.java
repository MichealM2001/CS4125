import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalController {
    private static final String CAR_CSV_FILE_PATH = "cars.csv";

    public static void rentCars(String username) {
        Scanner scanner = new Scanner(System.in);

        List<RentalModel> cars = loadCarsFromCsv();
        RentalView.displayAvailableCars(cars);

        System.out.print("Enter the name of the car you want to rent (or type 'exit' to log out): ");
        String selectedCar = scanner.nextLine();

        if (!selectedCar.equals("exit")) {
            RentalModel selectedCarObject = findCarByName(cars, selectedCar);

            if (selectedCarObject != null && selectedCarObject.getAvailability() > 0) {
                System.out.print("Enter the number of days you want to rent the car: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();
                double totalCost = calculateRentalCost(selectedCarObject, rentalDays, username);

// Decrease the availability by 1
selectedCarObject.decreaseAvailability();

RentalView.saveCarsToCsv(cars);




// Display updated availability
RentalView.displayUpdatedAvailability(selectedCarObject);

// Display rental details
RentalView.displayRentalDetails(selectedCar, rentalDays, totalCost);
            } else {
                System.out.println("Invalid selection or car not available for rent.");
            }
        }
    }

    public static List<RentalModel> loadCarsFromCsv() {
        List<RentalModel> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAR_CSV_FILE_PATH))) {
            String line;
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] carData = line.split(",");
                if (carData.length >= 3) {
                    String carName = carData[0];
                    double price = Double.parseDouble(carData[1]);
                    int availability = Integer.parseInt(carData[2]);

                    cars.add(new RentalModel(carName, price, availability));
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return cars;
    }

    public static RentalModel findCarByName(List<RentalModel> cars, String carName) {
        for (RentalModel car : cars) {
            if (car.getCarName().equalsIgnoreCase(carName)) {
                return car;
            }
        }
        return null;
    }


public static double calculateRentalCost(RentalModel selectedCarObject, int rentalDays, String username) {
    double pricePerDay = selectedCarObject.getPricePerDay();

    if (pricePerDay > 0.0) {
        double totalCost;

        if (hasDriverLicense(username)) {
            totalCost = applyDriverLicenseDiscount(pricePerDay, rentalDays);
            System.out.println("Driver's License Discount Applied: 10%");
        } else {
            totalCost = pricePerDay * rentalDays;
        }

        double penaltyPointsCost = getPenaltyPointsCost(username);
        totalCost += penaltyPointsCost; // Add penalty points cost
        if (penaltyPointsCost > 0.0) {
            System.out.println("Penalty Points Cost Applied: $" + penaltyPointsCost);
        }

        totalCost = applyGenderDiscount(username, totalCost);
        if (totalCost < pricePerDay * rentalDays) {
            System.out.println("Gender-Based Discount Applied: 5%");
        }

        System.out.println("Total Cost: $" + totalCost);
        return totalCost;
    }

    return 0.0;
}



private static boolean hasDriverLicense(String username) {
    try (BufferedReader br = new BufferedReader(new FileReader("registration.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] userData = line.split(",");
            if (userData.length >= 1 && userData[0].equals(username)) {
                return userData.length >= 3 && userData[2].trim().equalsIgnoreCase("yes");
            }
        }
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    return false;
}

private static double applyDriverLicenseDiscount(double pricePerDay, int rentalDays) {
    // Apply a 10% discount for having a driver's license
    return 0.9 * pricePerDay * rentalDays;
}

private static double getPenaltyPointsCost(String username) {
    try (BufferedReader br = new BufferedReader(new FileReader("registration.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] userData = line.split(",");
            if (userData.length >= 1 && userData[0].equals(username)) {
                int penaltyPoints = userData.length >= 5 ? Integer.parseInt(userData[4]) : 0;
                // Apply a cost of $5 per penalty point
                return penaltyPoints * 5.0;
            }
        }
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    return 0.0;
}


private static double applyGenderDiscount(String username, double totalCost) {
    try (BufferedReader br = new BufferedReader(new FileReader("registration.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] userData = line.split(",");
            if (userData.length >= 1 && userData[0].equals(username) && userData.length >= 6) {
                String gender = userData[5].trim().toLowerCase();
                // Apply a 5% discount for male users
                if (gender.equals("female")) {
                    return 0.95 * totalCost;
                }
            }
        }
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    return totalCost;
}


}