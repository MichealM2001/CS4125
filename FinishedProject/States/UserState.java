package States;

import java.util.List;

public interface UserState{
    String getUsername();
    void logOut(UserContext usercontext);
    void logIn(UserContext usercontext);
    void setUsername(String username);
    void setEmail(String email);
    String getEmail();
    List<String> getOrders();
    void addItem(String item);
    void removeItem(String item);
}