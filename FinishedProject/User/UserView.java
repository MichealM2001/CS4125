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

    private UserController controller;
    private JPanel leftPanel, rightPanel;
    private JLabel nameLabel, carLabel;
    private JButton editProfile;

    public UserView(UserContext user) {
        super("My Account");
        controller = new UserController(this, user);
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
                controller.openEditProfileDialog(user);
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

    
    

}
