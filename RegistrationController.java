import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController {

    public static void register() {
        RegistrationModel model = RegistrationView.getUserInput();
        RegistrationView.displayMessage("Registration successful!");
        RegistrationView.writeRegistrationDataToFile(model);
    }
}

class RegistrationView {

    public static RegistrationModel getUserInput() {
        String username = promptUser("Enter a username: ");
        String password = promptUser("Enter a password: ");
        String hasDriverLicense = getYesOrNoInput("Do you have a driver's license? (yes/no): ");
        String licenseDuration = "no";

        if ("yes".equals(hasDriverLicense)) {
            licenseDuration = getYesOrNoInput("Do you have your driver's license for 5 years or more? (yes/no): ");
        }

        int penaltyPoints = 0;
        if ("yes".equals(hasDriverLicense)) {
            penaltyPoints = getIntInput("Enter the number of penalty points on your license: ");
        }

        String gender = promptUser("Enter your gender (male/female): ");

        return new RegistrationModel(username, password, hasDriverLicense, licenseDuration, penaltyPoints, gender);
    }

    private static String promptUser(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextLine();
    }

    private static String getYesOrNoInput(String prompt) {
        String input;
        while (true) {
            input = promptUser(prompt).toLowerCase();
            if ("yes".equals(input) || "no".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
        return input;
    }

    private static int getIntInput(String prompt) {
        int input = 0;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(new Scanner(System.in).nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void writeRegistrationDataToFile(RegistrationModel model) {
        File file = new File("registration.csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            bw.write(model.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class RegistrationModel {
    private String username;
    private String password;
    private String hasDriverLicense;
    private String licenseDuration;
    private int penaltyPoints;
    private String gender;

    public RegistrationModel(String username, String password, String hasDriverLicense, String licenseDuration, int penaltyPoints, String gender) {
        this.username = username;
        this.password = password;
        this.hasDriverLicense = hasDriverLicense;
        this.licenseDuration = licenseDuration;
        this.penaltyPoints = penaltyPoints;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + hasDriverLicense + "," + licenseDuration + "," + penaltyPoints + "," + gender;
    }
}
