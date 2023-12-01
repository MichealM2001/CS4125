import java.util.Scanner;

public class CarView {
    Scanner scanner;

    public CarView() {
        scanner = new Scanner(System.in);
    }

    public int getUserChoice() {
        System.out.println("Choose an operation:");
        System.out.println("1. Add a car");
        System.out.println("2. Remove a car");
        System.out.println("3. Exit");
        return scanner.nextInt();
    }

    public Car getCarDetails() {
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

        return new Car(yearOfReg, model, price, classification);
    }

    public String getCarModelToRemove() {
        System.out.println("Enter the model of the car to remove:");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
