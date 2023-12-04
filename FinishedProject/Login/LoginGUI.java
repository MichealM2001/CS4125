package Login;
import javax.swing.*;

import DataInputs.ReadCSV;
import Home.HomeView;
import Registrations.RegistrationGUI;
import States.LoggedinState;
import States.UserContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public LoginGUI() {
        
        super("Car Rental System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(400, 200);
        setResizable(false);

        // Components
        usernameField = new JTextField();
        passwordField = new JPasswordField();  
        JButton loginButton = new JButton("Login");
        registerButton = new JButton("Create Account");
        // Layout
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(registerButton); 
        add(loginButton);

        // Event handling
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().toLowerCase();
                String password = new String(passwordField.getPassword());

                // Call your login logic
                LoginModel model = new LoginModel(username, password);
                boolean userFound = LoginView.authenticateUser(model);

                if (userFound) {

                    // Open the home frame
                    UserContext user = new UserContext();
                    user.setUsername(username);
                    HomeView homeView = new HomeView(user);
                    homeView.setVisible(true);


                    // Close the login frame
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid username or password. Please try again.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationGUI regView = new RegistrationGUI();
                regView.setVisible(true);
                dispose();
            }
            
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}