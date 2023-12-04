package States;

import java.util.List;

public interface UserState{
    String getUsername();
    void logOut(UserContext usercontext);
    void logIn(UserContext usercontext);
    void setUsername(String username);
    List<String> getOrders();
    void addOrder(String item);
    void removeOrder(String item);
    void addID(String id);
    String getID();
    String getLicense();
    void setLicense(String license);
    int getPenaltyPoints();
    void setPenaltyPoints(int points);
    void setGender(String gender);
    String getGender();

}