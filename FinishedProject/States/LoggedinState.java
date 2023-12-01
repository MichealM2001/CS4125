package States;

public class LoggedinState implements UserState{
    private String username;
    @Override
    public void logOut(UserContext usercontext){
        usercontext.setState(new LoggedoutState());
    }

    @Override
    public void logIn(UserContext usercontext){

    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public void setUsername(String username){
        this.username = username;
    }
}