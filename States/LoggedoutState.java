public class LoggedoutState implements UserState{
    @Override
    public void logOut(UserContext usercontext){

    }

    @Override 
    public void logIn(UserContext usercontext){
        usercontext.setState(new LoggedinState());
    }
}