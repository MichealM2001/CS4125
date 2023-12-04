package Home;



import Login.LoginGUI;
import States.UserContext;
import User.UserView;

public class HomeModel {

    public String getUsername(UserContext user){
        return user.getUsername();
    }

    public void logOut(HomeView homeView, UserContext user){
        user.logOut();
        new LoginGUI().setVisible(true);
        homeView.dispose();
    }

    public void goToUser(HomeView homeView, UserContext user){
        UserView userView = new UserView(user);
        userView.setVisible(true);
        homeView.dispose();
    }

    public void addUserContext(UserContext user){
        user.logIn(false);
    }

    
    
}
