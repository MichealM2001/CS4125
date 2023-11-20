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

