import java.io.*;
import java.util.Scanner;

public class LoginManager {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("registration.csv"))) {
            String line;
            boolean userFound = false;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 2 && userData[0].equals(username) && userData[1].equals(password)) {
                    userFound = true;
                    System.out.println("Login successful!");
                    RentalManager.rentCars(username); // Call rentCars method
                    break;
                }
            }
            if (!userFound) {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
