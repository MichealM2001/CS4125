package User;

public class UserController {
    private UserView view;
    private UserModel userModel;

    public UserController(UserView view){
        this.view = view;
    }

    public String getName(){
        return userModel.getName();
    }
}
