package States;

public class LoggedoutState implements UserState{

    @Override
    public void logOut(UserContext usercontext){

    }

    @Override 
    public void logIn(UserContext usercontext){
        usercontext.setState(new LoggedinState());
    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public void setUsername(String username){
    }
}