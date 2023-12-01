package Home;

import States.UserContext;

public class HomeModel {
    private UserContext user;

    public String getUsername(){
        return user.getUsername();
    }

    public void logOut(){
        user.logOut();
    }
}
