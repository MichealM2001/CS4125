import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    public static void login() {
        LoginView.displayMessage("Enter your username: ");
        String username = LoginView.getUserInput();
        LoginView.displayMessage("Enter your password: ");
        String password = LoginView.getUserInput();

        LoginModel model = new LoginModel(username, password);
        boolean userFound = LoginView.authenticateUser(model);

        if (userFound) {
            LoginView.displayMessage("Login successful!");
            RentalController.rentCars(username); 
        } else {
            LoginView.displayMessage("Invalid username or password. Please try again.");
        }
    }
}

