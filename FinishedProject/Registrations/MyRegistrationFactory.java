package Registrations;

public class MyRegistrationFactory implements RegistrationFactory {
    @Override
    public RegistrationModel createRegistrationModel(String username, String password, String hasDriverLicense, String licenseDuration, int penaltyPoints, String gender, String id) {
        return new RegistrationModel(username, password, hasDriverLicense, licenseDuration, penaltyPoints, gender, id);
    }
}
