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

    @Override
    public String toString() {
        return username + "," + password + "," + hasDriverLicense + "," + licenseDuration + "," + penaltyPoints + "," + gender;
    }
}
