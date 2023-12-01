package Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginView {

    public static String getUserInput() {
        return new Scanner(System.in).nextLine();
    }

    public static void displayMessage(String message) {
        System.out.print(message);
    }

    public static boolean authenticateUser(LoginModel model) {
        try (BufferedReader br = new BufferedReader(new FileReader("registration.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 2 && userData[0].equals(model.getUsername()) && userData[1].equals(model.getPassword())) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }
}
