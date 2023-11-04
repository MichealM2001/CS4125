import java.io.*;
import java.util.Scanner;

public class RegistrationManager {
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        File file = new File("registration.csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (!file.exists()) {
                file.createNewFile(); // Create the file if it doesn't exist
            }
            bw.write(username + "," + password);
            bw.newLine();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void rentCars(String username) {
        // Implement the rentCars method logic here
    }
}
