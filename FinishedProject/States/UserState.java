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
    void addOrder(String item);
    void removeOrder(String item);
    void addID(String id);
    String getID();
}