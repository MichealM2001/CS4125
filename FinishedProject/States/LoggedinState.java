package States;

import java.util.ArrayList;
import java.util.List;

public class LoggedinState implements UserState{
    private String username;
    private String email;
    private List<String> orders;

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
    public String getEmail(){
        return email;
    }

    @Override
    public void setEmail(String email){
        this.email = email;
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


}