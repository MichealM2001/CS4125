package States;

import java.util.ArrayList;
import java.util.List;

public class LoggedinState implements UserState{
    private String username;
    private String email;
    private List<String> orders;
    private String id;
    private int points;
    private String gender;
    private String license;

    public LoggedinState(){
        orders = new ArrayList<>();

    }

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

    @Override
    public List<String> getOrders() {
        return orders;
    }

    @Override
    public void addOrder(String item) {
        orders.add(item);
    }

    @Override
    public void removeOrder(String item) {
        orders.remove(item);
    }

    @Override
    public void addID(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getLicense() {
        return license;
    }

    @Override
    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public int getPenaltyPoints() {
        return points;
    }

    @Override
    public void setPenaltyPoints(int points) {
        this.points = points;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getGender() {
        return gender;
    }


}