package Registrations;
import java.util.Scanner;
import java.util.UUID;

public class RegistrationModel {
    private String username;
    private String password;
    private String hasDriverLicense;
    private String licenseDuration;
    private int penaltyPoints;
    private String gender;
    private String id;

    public RegistrationModel(String username, String password, String hasDriverLicense, String licenseDuration, int penaltyPoints, String gender, String id) {
        this.username = username;
        this.password = password;
        this.hasDriverLicense = hasDriverLicense;
        this.licenseDuration = licenseDuration;
        this.penaltyPoints = penaltyPoints;
        this.gender = gender;
        this.id = id;
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

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + hasDriverLicense + "," + licenseDuration + "," + penaltyPoints + "," + gender;
    }

        public static String getUserInput() {
        return new Scanner(System.in).nextLine();
    }

}
