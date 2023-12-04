


package User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import States.UserContext;

public class UserView extends JFrame {

    private UserController controller;
    private JPanel leftPanel, rightPanel;
    private JLabel nameLabel, carLabel;
    private JButton editProfile, userButton;
    private JTextArea cars;

    public UserView(UserContext user) {
        super("My Account");
        controller = new UserController(this, user);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(1000, 600);

        JMenuBar topBar = new JMenuBar();
        topBar.setOpaque(true);
        topBar.setBackground(new Color(200,200,200));
        topBar.setPreferredSize(new Dimension(200,50));
        
        
        topBar.add(Box.createRigidArea(new Dimension(17,0)));
        userButton = new JButton("Back");
        userButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToHome();
            }
            
        });

        topBar.add(userButton);

        topBar.add(Box.createRigidArea(new Dimension(780,0)));
        
        userButton = new JButton("Sign out");
        userButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.logOut();
            }
            
        });
        topBar.add(userButton);
        setJMenuBar(topBar);

        nameLabel = new JLabel();
        nameLabel.add(Box.createRigidArea(new Dimension(0,500)));
        nameLabel.setText("");
        add(nameLabel);
    

        editProfile = new JButton("Edit Profile");
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.openEditProfileDialog(user);
            }

        });

        leftPanel = new JPanel();
        leftPanel.add(editProfile);


        Font font = new Font("Arial", Font.BOLD, 28);  
        

        rightPanel = new JPanel();
        rightPanel.setSize(500, 600);
        carLabel = new JLabel();
        carLabel.setOpaque(false);
        carLabel.setFont(font);
        carLabel.setText("Rented cars:");

        rightPanel.add(carLabel);

        cars = new JTextArea();
        cars.append(controller.getCar(0).toString() + "\n\n\n");
        cars.append(controller.getCar(1).toString() + "\n\n\n");
        cars.append(controller.getCar(2).toString() + "\n\n\n");
        cars.setOpaque(true);
        cars.setFont(font);
        rightPanel.add(cars);
        setLayout(new BorderLayout());
        

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel);
    }

   


}