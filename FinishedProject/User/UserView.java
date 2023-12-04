package User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import States.UserContext;

public class UserView extends JFrame {

    private JPanel leftPanel, rightPanel;
    private JLabel nameLabel, carLabel;
    private JButton editProfile;

    public UserView(UserContext user) {
        super("My Account");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(1000, 600);

        leftPanel = new JPanel();
        leftPanel.setSize(500, 600);
        nameLabel = new JLabel();
        nameLabel.setText("Welcome " + user.getUsername().toString());
        leftPanel.add(nameLabel);

        editProfile = new JButton("Edit Profile");
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openEditProfileDialog(user);
            }
            
        });

        leftPanel.add(editProfile);

        rightPanel = new JPanel();
        rightPanel.setSize(500, 600);
        carLabel = new JLabel();
        carLabel.setText("Tes");
        rightPanel.add(carLabel);

        setLayout(new BorderLayout());
        
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel);
    }

    private void openEditProfileDialog(UserContext user) {
        // Temporarily hardcoded profileData for testing
        String csvFilePath = "FinishedProject\\CSVs\\registration.csv";
        String[] profileData = getUserProfileDataFromCSV(user.getUsername().toString(), csvFilePath);
        
        EditProfileDialog editProfileDialog = new EditProfileDialog(this, user, profileData);
        
        editProfileDialog.setVisible(true);
    }
    

    public String[] getUserProfileDataFromCSV(String username, String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header
            br.readLine();
    
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (isValidUserData(userData, username)) {
                    System.out.println("Profile Data: " + Arrays.toString(userData));
                    return userData;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("User not found: " + username);
        return null;
    }
    
    private boolean isValidUserData(String[] userData, String username) {
        return userData.length >= 7 && userData[0].trim().equalsIgnoreCase(username.trim());
    }
    

}
