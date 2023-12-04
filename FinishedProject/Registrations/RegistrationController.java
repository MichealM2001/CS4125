package Registrations;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController {
    // Use the factory to create the RegistrationModel
    public static void register(RegistrationFactory factory) {
        RegistrationModel model = RegistrationView.getUserInput();
        RegistrationModel registrationModel = factory.createRegistrationModel(
            model.getUsername(),
            model.getPassword(),
            model.getHasDriverLicense(),
            model.getLicenseDuration(),
            model.getPenaltyPoints(),
            model.getGender()
        );

        RegistrationView.displayMessage("Registration successful!");
        RegistrationView.writeRegistrationDataToFile(registrationModel);
    }
}
