package States;
public class UserContext {
    private UserState state;

    public UserContext(){
        state = new LoggedinState();
    }

    public void logOut(){
        state.logOut(this);
    }

    public void logIn(){
        state.logIn(this);
    }

    public void setState(UserState state){
        this.state = state;
    }

    public UserState getCurrentState(){
        return state;
    }

    public void setUsername(String username){
        state.setUsername(username);
    }

    public String getUsername(){
        return state.getUsername();
    }

}