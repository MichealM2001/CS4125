package States;

import java.util.ArrayList;
import java.util.List;

import DataInputs.ReadCSV;

public class UserContext {
    private UserState state;
    private List<String[]> authFile = new ArrayList<>();

    public UserContext(){
        state = new LoggedinState();
    }

    public void logOut(){
        authFile.clear();
        authFile.add(new String[]{"false"});
        ReadCSV.writeToCSVFile("FinishedProject\\CSVs\\authorised.csv", authFile, false);
        state.logOut(this);
    }

    public void logIn(){
        authFile.clear();
        authFile.add(new String[]{"true"});
        ReadCSV.writeToCSVFile("FinishedProject\\CSVs\\authorised.csv", authFile, false);
        state.logIn(this);
    }

    public void setState(UserState state){
        this.state = state;
    }

    public UserState getCurrentState(){
        return state;
    }

    public void setUsername(String username){
        state.setUsername(username);
    }

    public String getUsername(){
        return state.getUsername();
    }

    public void setEmail(String email){
        state.setEmail(email);
    }

    public String getEmail(){
        return state.getEmail();
    }

    public void addOrder(String item){
        state.addOrder(item);
    }

    public void addID(String id){
        state.addID(id);
    }

    public String getID(){
        return state.getID();
    }
}