package Home;

import javax.swing.*;

import States.UserContext;

import java.awt.*;
import java.awt.event.*;

public class HomeView extends JFrame{
    private HomeController controller;
    private JButton userButton;

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
    }
}