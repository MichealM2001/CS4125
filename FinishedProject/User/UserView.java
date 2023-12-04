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
    private JButton editProfile, userButton;


    public UserView(UserContext user) {
        super("My Account");
        controller = new UserController(this, user);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(1000, 600);
        setResizable(false);

        JMenuBar topBar = new JMenuBar();
        topBar.setOpaque(true);
        topBar.setBackground(new Color(200,200,200));
        topBar.setPreferredSize(new Dimension(200,50));
        
        
        topBar.add(Box.createRigidArea(new Dimension(17,0)));
        userButton = new JButton("My Account");
        userButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             }
            
        });

        topBar.add(userButton);

        topBar.add(Box.createRigidArea(new Dimension(750,0)));
        
        userButton = new JButton("Sign out");
        userButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.logOut();
            }
            
        });
        topBar.add(userButton);
        add(topBar);


    }

    
    

}
