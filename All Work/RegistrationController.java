
public class RegistrationController {

    public static void register() {
        RegistrationModel model = RegistrationView.getUserInput();
        RegistrationView.displayMessage("Registration successful!");
        RegistrationView.writeRegistrationDataToFile(model);
    }
}

