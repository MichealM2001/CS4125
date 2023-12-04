package User;

import States.UserContext;

public class UserController {
    private UserView view;
    private UserModel userModel;

    public UserController(UserView view, UserContext user){
        this.view = view;
        userModel = new UserModel(user);
    }

    public String getName(){
        return userModel.getName();
    }

    public void logOut(){
        userModel.logOut(view);
    }

    public void openEditProfileDialog(UserContext user) {
        userModel.openEditProfileDialog(view, user);
    }

    public void getUserProfileDataFromCSV(String username, String CSVpath){
        userModel.getUserProfileDataFromCSV(username, CSVpath);
    }
}
