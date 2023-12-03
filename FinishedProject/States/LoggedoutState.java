package States;

import java.util.List;

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

    @Override
    public void setEmail(String email) {
     
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public List<String> getOrders() {
        
        return null;
    }

    @Override
    public void addItem(String item) {
       
    }

    @Override
    public void removeItem(String item) {
        
    }
}