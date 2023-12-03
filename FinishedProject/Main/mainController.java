package Main;

import Home.HomeView;
import States.UserContext;

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
        HomeView homeView = new HomeView(user);
        homeView.setVisible(true);
    }
}
