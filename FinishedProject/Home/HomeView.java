package Home;

import javax.swing.*;

import Cars.CarManagementGUI;
import Cars.CarRentalGUI;
import States.UserContext;


import java.awt.*;
import java.awt.event.*;

public class HomeView extends JFrame{
    private HomeController controller;
    private JButton userButton;
    private JPanel leftPanel;
    private JLabel nameLabel;
    private JButton carManagementButton;
    private JButton carRentalButton;


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
        
        // Initialize the Car Management button
        carManagementButton = new JButton("Manage Cars");
        carManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCarManagementGUI();
            }
        });

         // Initialize the Car Rental button
        carRentalButton = new JButton("Rent a Car");
        carRentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCarRentalGUI();
            }
        });

         this.add(carManagementButton);
         this.add(carRentalButton);
        // JMenu userMenu = new JMenu("User");
        // userMenu.addMenuListener(new MenuListener() {

        //     @Override
        //     public void menuSelected(MenuEvent e) {
        //         controller.goToUser();
        //     }

        //     @Override
        //     public void menuDeselected(MenuEvent e) {
        //         // // TODO Auto-generated method stub
        //         // throw new UnsupportedOperationException("Unimplemented method 'menuDeselected'");
        //     }

        //     @Override
        //     public void menuCanceled(MenuEvent e) {
        //         // // TODO Auto-generated method stub
        //         // throw new UnsupportedOperationException("Unimplemented method 'menuCanceled'");
        //     }
            
        // });
        // topBar.add(userMenu);

        setJMenuBar(topBar);

        leftPanel = new JPanel();
        leftPanel.setSize(500, 600);
        nameLabel = new JLabel();
        nameLabel.add(Box.createRigidArea(new Dimension(0,500)));
        nameLabel.setText("Welcome");
        leftPanel.add(nameLabel);
        
        leftPanel.add(nameLabel);
        add(leftPanel);
        
        
    }

    private void openCarManagementGUI() {
         CarManagementGUI carManagement = new CarManagementGUI();
         carManagement.setVisible(true);
        }

        private void openCarRentalGUI() {
        CarRentalGUI carRental = new CarRentalGUI();
        carRental.setVisible(true);
        }
}
