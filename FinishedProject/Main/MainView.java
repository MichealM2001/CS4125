package Main;

import Home.HomeView;
import Login.LoginGUI;

public class MainView {
    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel);

        

        if(mainController.checkLoginStatus()){
            new HomeView().setVisible();
        }else{
            new LoginGUI().setVisible(true);
        }
    }
}
