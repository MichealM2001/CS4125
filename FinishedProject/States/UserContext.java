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
        List<String[]> authData, userData = new ArrayList<>();
        authData = ReadCSV.CSVToData("FinishedProject\\CSVs\\authorised.csv");
        if(authData.size() == 2){
            state.logIn(this);
            String userId = authData.get(0)[1];
            userData = ReadCSV.CSVToData("FinishedProject\\CSVs\\registration.csv");
            for (String[] strings : userData) {
                if(strings[6].equals(userId)){
                    state.setUsername(strings[0]);
                    state.setGender(strings[5]);
                    state.setLicense(strings[3]);
                    state.setPenaltyPoints(Integer.parseInt(strings[4]));
                    state.addID(userId);

                }
            }
        }
        else{
            String username = state.getUsername();
            userData = ReadCSV.CSVToData("FinishedProject\\CSVs\\registration.csv");
            for (String[] strings : userData) {
                if(strings[0].toLowerCase().equals(username)){
                    state.setGender(strings[5]);
                    state.setLicense(strings[3]);
                    state.setPenaltyPoints(Integer.parseInt(strings[4]));
                    state.addID(strings[6]);

                }
            }
        } 
        authFile.clear();
        authFile.add(new String[]{"true", state.getID().toString()});
        ReadCSV.writeToCSVFile("FinishedProject\\CSVs\\authorised.csv", authFile, false);      
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

    public void addOrder(String item){
        state.addOrder(item);
    }

    public void addID(String id){
        state.addID(id);
    }

    public String getID(){
        return state.getID();
    }

    public String getLicense() {
        return state.getLicense();
    }

    public void setLicense(String hasLicense) {
       state.setLicense(hasLicense); 
    }

    public int getPenaltyPoints() {
        return state.getPenaltyPoints();
    }

    public void setPenaltyPoints(int points) {
        state.setPenaltyPoints(points);
    }

    public void setGender(String gender) {
        state.setGender(gender);    
    }

    public String getGender() {
        return state.getGender();
    }
}