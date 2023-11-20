public class LoggedinState implements UserState{
    @Override
    public void logOut(UserContext usercontext){
        usercontext.setState(new LoggedoutState());
    }

    @Override
    public void logIn(Usercontext usercontext){

    }
}