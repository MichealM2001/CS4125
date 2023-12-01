import java.io.*;
import java.util.Scanner;

public class RegistrationManager {
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Prompt the user for a valid driver's license status (yes or no)
        String hasDriverLicense;
        while (true) {
            System.out.print("Do you have a driver's license? (yes/no): ");
            hasDriverLicense = scanner.nextLine().toLowerCase(); // Convert input to lowercase

            if ("yes".equals(hasDriverLicense) || "no".equals(hasDriverLicense)) {
                break; // Valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        // Prompt the user for the duration of their driver's license (5 years or more)
        String licenseDuration;
        if ("yes".equals(hasDriverLicense)) {
            while (true) {
                System.out.print("Do you have your driver's license for 5 years or more? (yes/no): ");
                licenseDuration = scanner.nextLine().toLowerCase(); // Convert input to lowercase

                if ("yes".equals(licenseDuration) || "no".equals(licenseDuration)) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        } else {
            licenseDuration = "no"; // Default to "no" if the user does not have a driver's license
        }

        // Prompt the user for a valid gender (male or female)
        String gender;
        while (true) {
            System.out.print("Enter your gender (male/female): ");
            gender = scanner.nextLine().toLowerCase(); // Convert input to lowercase

            if ("male".equals(gender) || "female".equals(gender)) {
                break; // Valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        }

        File file = new File("registration.csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (!file.exists()) {
                file.createNewFile(); // Create the file if it doesn't exist
            }
            // Write user registration data including driver's license duration and gender
            bw.write(username + "," + password + "," + hasDriverLicense + "," + licenseDuration + "," + gender);
            bw.newLine();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
