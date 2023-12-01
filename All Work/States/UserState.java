package States;

public interface UserState{
    String getUsername();
    void logOut(UserContext usercontext);
    void logIn(UserContext usercontext);
    void setUsername(String username);

}