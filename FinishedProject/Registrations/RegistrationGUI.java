package Registrations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class RegistrationGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox hasDriverLicenseCheckBox;
    private JCheckBox noDriverLicenseCheckBox;
    private JRadioButton fiveYearsRadioButton;
    private JRadioButton lessThanFiveYearsRadioButton;
    private JComboBox<Integer> penaltyPointsComboBox;
    private JComboBox<String> genderComboBox;

    public RegistrationGUI() {
        super("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(550, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        // Username
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password
        panel.add(new JLabel("Password (minimum 8 characters):"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Has Driver's License
        panel.add(new JLabel("Do you have a driver's license?"));
        JPanel licensePanel = new JPanel();
        hasDriverLicenseCheckBox = new JCheckBox("yes");
        noDriverLicenseCheckBox = new JCheckBox("no");
        ButtonGroup licenseGroup = new ButtonGroup();
        licenseGroup.add(hasDriverLicenseCheckBox);
        licenseGroup.add(noDriverLicenseCheckBox);
        licensePanel.add(hasDriverLicenseCheckBox);
        licensePanel.add(noDriverLicenseCheckBox);
        panel.add(licensePanel);

        // License Duration
        panel.add(new JLabel("How long have you had your driver's license?"));
        JPanel licenseDurationPanel = new JPanel();
        fiveYearsRadioButton = new JRadioButton("5+ years");
        lessThanFiveYearsRadioButton = new JRadioButton("Less than 5 years");
        ButtonGroup licenseDurationGroup = new ButtonGroup();
        licenseDurationGroup.add(fiveYearsRadioButton);
        licenseDurationGroup.add(lessThanFiveYearsRadioButton);
        licenseDurationPanel.add(fiveYearsRadioButton);
        licenseDurationPanel.add(lessThanFiveYearsRadioButton);
        panel.add(licenseDurationPanel);

        // Penalty Points
        panel.add(new JLabel("Penalty Points:"));
        Integer[] penaltyPointsArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        penaltyPointsComboBox = new JComboBox<>(penaltyPointsArray);
        panel.add(penaltyPointsComboBox);

        // Gender
        panel.add(new JLabel("Gender:"));
        String[] genderOptions = {"male", "female"};
        genderComboBox = new JComboBox<>(genderOptions);
        panel.add(genderComboBox);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String hasDriverLicense = hasDriverLicenseCheckBox.isSelected() ? "yes" : (noDriverLicenseCheckBox.isSelected() ? "no" : "");
        String licenseDuration = fiveYearsRadioButton.isSelected() ? "5+ years" : "no";
        int penaltyPoints = (Integer) penaltyPointsComboBox.getSelectedItem();
        String gender = (String) genderComboBox.getSelectedItem();
        String id = UUID.randomUUID().toString();

        // Perform registration logic
        if (isRegistrationDataValid(username, password, penaltyPoints, hasDriverLicense)) {
            if (isUsernameAvailable(username)) {
                RegistrationModel registrationModel = new RegistrationModel(username, password, hasDriverLicense, licenseDuration, penaltyPoints, gender, id);
                saveUserDataToFile(registrationModel);
                JOptionPane.showMessageDialog(this, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Username is not available. Please choose another.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid registration data. Please check your input.");
        }
    }

    private boolean isRegistrationDataValid(String username, String password, int penaltyPoints, String hasDriverLicense) {
        // Add your validation logic here
        return !username.isEmpty() && password.length() >= 8 && penaltyPoints >= 0 && (!hasDriverLicense.isEmpty() || (hasDriverLicense.isEmpty() && noDriverLicenseCheckBox.isSelected()));
    }

    private boolean isUsernameAvailable(String username) {
        // Add logic
        return true; 
    }

    private void saveUserDataToFile(RegistrationModel model) {
        RegistrationView.writeRegistrationDataToFile(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationGUI();
            }
        });
    }
}
