package Home;

import java.util.ArrayList;
import java.util.List;

import DataInputs.ReadCSV;
import Login.LoginGUI;
import States.UserContext;
import User.UserView;

public class HomeModel {
    
    private List<String[]> authFile = new ArrayList<>();

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
        authFile.add(new String[]{user.getUsername().toString() });
        ReadCSV.writeToCSVFile("FinishedProject\\CSVs\\authorised.csv", authFile, true);
    }

    
}
