package Home;

import States.UserContext;
import User.UserView;

public class HomeModel {
    private UserContext user;
    private HomeController homeController;
    private HomeView homeView;

    public String getUsername(){
        return user.getUsername();
    }

    public void logOut(){
        user.logOut();
    }

    public void goToUser(HomeView homeView){
        UserView userView = new UserView();
        userView.setVisible(true);
        homeView.dispose();
    }
}
