package User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import States.UserContext;

public class EditProfileDialog extends JDialog {

    private JTextField usernameField, passwordField;
    private JCheckBox hasLicenseCheckBox, durationCheckBox;
    private JComboBox<String> genderComboBox, pointsComboBox;
    private JButton saveButton;

    public EditProfileDialog(UserView parent, UserContext user, String[] profileData) {
        super(parent, "Edit Profile", true);
        setSize(500, 500);
        setLocationRelativeTo(parent);

        // Initialize fields
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);

        // Initialize JCheckBox components
        hasLicenseCheckBox = new JCheckBox();
        durationCheckBox = new JCheckBox();

        // Initialize JComboBox components
        genderComboBox = new JComboBox<>(new String[]{"male", "female"});
        pointsComboBox = new JComboBox<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCSVFile(user.getID());
                dispose(); // Close the dialog
            }
        });

        setLayout(new GridLayout(9, 2)); // Keep the rows as 9
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Has Driver License:"));
        add(hasLicenseCheckBox);
        add(new JLabel("Has Driver License longer than 5 years?"));
        add(durationCheckBox);
        add(new JLabel("Gender:"));
        add(genderComboBox);
        add(new JLabel("Number of penalty points:"));
        add(pointsComboBox);
        add(new JLabel()); // Empty label for spacing
        add(saveButton);

        // Set the fields based on profileData
        if (profileData != null) {
            usernameField.setText(profileData[0]);
            passwordField.setText(profileData[1]);
            // Set the state of the JCheckBox components based on the values in profileData[2] and profileData[3]
            hasLicenseCheckBox.setSelected("yes".equalsIgnoreCase(profileData[2]));
            durationCheckBox.setSelected("yes".equalsIgnoreCase(profileData[3]));

            // Set the selected item in JComboBox components
            genderComboBox.setSelectedItem(profileData[5].toLowerCase());
            pointsComboBox.setSelectedItem(profileData[4]);
        } else {
            System.out.println("Profile data is null or user not found");
        }
    }

    private void updateCSVFile(String id) {
        // Read all lines from the CSV file
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("FinishedProject\\CSVs\\registration.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle the exception appropriately
            return;
        }

        // Find the line with the specified username
        for (int i = 1; i < lines.size(); i++) { // Start from index 1 to skip the header
            String[] userData = lines.get(i).split(",");
            if (userData.length >= 7 && userData[6].equalsIgnoreCase(id)) {
                // Update the values in the CSV file
                userData[0] = usernameField.getText();
                userData[2] = hasLicenseCheckBox.isSelected() ? "yes" : "no";
                userData[3] = durationCheckBox.isSelected() ? "yes" : "no";
                userData[4] = pointsComboBox.getSelectedItem().toString();
                userData[5] = genderComboBox.getSelectedItem().toString();
                lines.set(i, String.join(",", userData));
                break;
            }
        }

        // Write the updated lines back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("FinishedProject\\CSVs\\registration.csv"))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void updateFields(String[] profileData) {
        if (profileData != null && profileData.length >= 8) {
            usernameField.setText(profileData[0]);
            passwordField.setText(profileData[1]);
            hasLicenseCheckBox.setSelected("yes".equalsIgnoreCase(profileData[2]));
            durationCheckBox.setSelected("yes".equalsIgnoreCase(profileData[3]));
            genderComboBox.setSelectedItem(profileData[5].toLowerCase());
            pointsComboBox.setSelectedItem(profileData[4]);
        } else {
            // Handle the case where the data is not valid
        }
    }
}
