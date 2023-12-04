package Home;

import States.UserContext;

public class HomeController {
    private HomeView homeView;
    private HomeModel homeModel = new HomeModel();
    
    public HomeController(HomeView homeView, UserContext user){
        this.homeView = homeView;
        addUserContext(user);
    }

    public void goToUser(UserContext user){
        homeModel.goToUser(homeView, user);
    }

    public void logOut(UserContext user){
        homeModel.logOut(homeView, user);
    }

    public void addUserContext(UserContext user){
        homeModel.addUserContext(user);
    }

}
