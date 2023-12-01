import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        super("Car Rental System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Components
        usernameField = new JTextField();
        passwordField = new JPasswordField();  
        JButton loginButton = new JButton("Login");

        // Layout
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel()); // Empty cell
        add(loginButton);

        // Event handling
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Call your login logic
                LoginModel model = new LoginModel(username, password);
                boolean userFound = LoginView.authenticateUser(model);

                if (userFound) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login successful!");

                    // Open the car rental frame
                    new CarRentalGUI(username).setVisible(true);

                    // Close the login frame
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid username or password. Please try again.");
                }
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