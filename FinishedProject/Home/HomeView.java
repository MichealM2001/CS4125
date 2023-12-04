package Home;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import States.UserContext;


import java.awt.*;
import java.awt.event.*;

public class HomeView extends JFrame{
    private HomeController controller;
    private JButton userButton, carManagementButton, carRentalButton;
    private JPanel leftPanel, rightPanel;
    private JTextArea welcome;


    public HomeView(UserContext user){
        super("Car Rental System - Home Screen");
        controller = new HomeController(this, user);

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
                controller.goToUser(user);
                System.out.println("--------------");
             }
            
        });

        topBar.add(userButton);

        topBar.add(Box.createRigidArea(new Dimension(750,0)));
        
        userButton = new JButton("Sign out");
        userButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.logOut(user);
            }
            
        });
        topBar.add(userButton);
      

        
        setJMenuBar(topBar);

        setLayout(new BorderLayout());
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));


        Font font = new Font("Arial", Font.BOLD, 28);  
        welcome = new JTextArea();
        welcome.setOpaque(false);
        welcome.setFont(font);
        welcome.append("Welcome to Cios!\n\n\n");
        welcome.append("We pride ourselves on delivering an exceptional \ncar rental experience tailored to your travel needs.\n\n\n");
        welcome.append("Whether it's a weekend getaway, a business trip, \nor your daily commute, we've got you covered.");
        leftPanel.add(welcome);


        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setBorder(new EmptyBorder(225, 10, 10, 75));
  
        // Initialize the Car Management button
        carManagementButton = new JButton("Manage Cars");
        carManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.openCarManagementGUI();
            }
        });

         // Initialize the Car Rental button
        carRentalButton = new JButton("Rent a Car");
        carRentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.openCarRentalGUI();
            }
        });

        rightPanel.add(carRentalButton);
        
        add(rightPanel, BorderLayout.EAST);
        add(leftPanel, BorderLayout.WEST);
    }

    
}
