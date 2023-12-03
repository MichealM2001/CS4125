package Home;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.*;

public class HomeView extends JFrame{
    private HomeController controller = new HomeController(this);
    private JButton userButton;

    public HomeView(){
        super("Car Rental System - Home Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(1000, 600);

        JMenuBar topBar = new JMenuBar();
        topBar.setOpaque(true);
        topBar.setBackground(new Color(200,200,200));
        topBar.setPreferredSize(new Dimension(200,50));

        userButton = new JButton("My Account");
        userButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goToUser();
                System.out.println("--------------");
                // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
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