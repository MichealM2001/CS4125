package User;

import States.UserContext;

public class UserModel {
    private UserContext user;

    public UserModel(UserContext user){
        this.user = user;
    }

    public String getName(){
        return user.getUsername();
    }
}
