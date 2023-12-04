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
    public List<String> getOrders() {
        
        return null;
    }

    @Override
    public void addOrder(String item) {
       
    }

    @Override
    public void removeOrder(String item) {
        
    }

    @Override
    public void addID(String id) {
        
    }

    @Override
    public String getID() {
        return null; 
    }

    @Override
    public String getLicense() {
        return null; 
    }

    @Override
    public void setLicense(String license) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLicense'");
    }

    @Override
    public int getPenaltyPoints() {
        return 0; 
    }

    @Override
    public void setPenaltyPoints(int points) {
        
    }

    @Override
    public void setGender(String gender) {
        
    }

    @Override
    public String getGender() {
        return null; 
    }
}