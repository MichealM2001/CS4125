package User;

import javax.swing.*;

import States.UserContext;

public class UserView extends JFrame {
    
     public UserView(UserContext user) {
        super("My Account");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(1000, 600);




    }
}
