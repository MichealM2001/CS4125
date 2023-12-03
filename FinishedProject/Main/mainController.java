package Main;

import Home.HomeController;
import Home.HomeView;
import States.UserContext;
import User.UserController;
import User.UserView;

public class MainController {

    private MainModel mainModel;

    public MainController(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public boolean checkLoginStatus() {
        return mainModel.isLoggedIn();

    }

    public void goToHome(){
        UserContext user = new UserContext(); 
        HomeView homeView = new HomeView();
        homeView.setVisible(true);
    }
}
