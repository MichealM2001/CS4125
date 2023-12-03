package Main;

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
}
