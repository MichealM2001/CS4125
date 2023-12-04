/*package Main;

import Login.LoginGUI;

public class MainView {
    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel);

        if(mainController.checkLoginStatus()){
            mainController.goToHome();
        }else{
            new LoginGUI().setVisible(true);
        }
    }
}*/

package Main;

import Login.LoginGUI;
import Cars.CarManagementGUI;
import Cars.CarRentalGUI;

public class MainView {
    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel);

        if(mainController.checkLoginStatus()){
            // Go to home screen 
            mainController.goToHome();

            // Display Car Management GUI
            CarManagementGUI carManagement = new CarManagementGUI();
            carManagement.setVisible(true);

            // Display Car Rental GUI
            CarRentalGUI carRental = new CarRentalGUI("username");
            carRental.setVisible(true);

        }else{
            new LoginGUI().setVisible(true);
        }
    }
}

