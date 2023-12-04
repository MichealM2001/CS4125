package Registrations;
import java.util.Scanner;

public class RegistrationModel {
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHasDriverLicense() {
        return hasDriverLicense;
    }

    public String getLicenseDuration() {
        return licenseDuration;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + hasDriverLicense + "," + licenseDuration + "," + penaltyPoints + "," + gender;
    }

        public static String getUserInput() {
        return new Scanner(System.in).nextLine();
    }

}
