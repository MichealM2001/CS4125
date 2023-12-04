package Main;

import java.util.ArrayList;
import java.util.List;

import DataInputs.ReadCSV;
import States.UserContext;

public class MainModel {

    private static UserContext user = new UserContext();

    public Boolean isLoggedIn(){
        List<String[]> data = new ArrayList<>();

        data = ReadCSV.CSVToData("FinishedProject\\CSVs\\authorised.csv");
        String[] currentUser = data.get(0);
        if(currentUser[0].equals("true")){
            return true;
        }
        return false;
    }

    
}