package Registrations;
public interface RegistrationFactory {
    RegistrationModel createRegistrationModel(String username, String password, String hasDriverLicense, String licenseDuration, int penaltyPoints, String gender, String id);
}
