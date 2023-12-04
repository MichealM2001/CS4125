package User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import Home.HomeView;
import Login.LoginGUI;
import States.UserContext;

public class UserModel {
    private UserContext user;

    public UserModel(UserContext user){
        this.user = user;
    }

    public String getName(){
        return user.getUsername();
    }

    public void logOut(UserView view){
        user.logOut();
        new LoginGUI().setVisible(true);
        view.dispose();
    }

    public void goToHome(UserView userView){
        HomeView view = new HomeView(user);
        view.setVisible(true);
        userView.dispose();
    }

    public void openEditProfileDialog(UserView view, UserContext user) {
        // Temporarily hardcoded profileData for testing
        String csvFilePath = "FinishedProject\\CSVs\\registration.csv";
        String[] profileData = getUserProfileDataFromCSV(user.getUsername().toString(), csvFilePath);
        
        EditProfileDialog editProfileDialog = new EditProfileDialog(view, user, profileData);
        
        editProfileDialog.setVisible(true);
    }
    

    public String[] getUserProfileDataFromCSV(String username, String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header
            br.readLine();
    
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (isValidUserData(userData, username)) {
                    System.out.println("Profile Data: " + Arrays.toString(userData));
                    return userData;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("User not found: " + username);
        return null;
    }
    
    private boolean isValidUserData(String[] userData, String username) {
        return userData.length >= 7 && userData[0].trim().equalsIgnoreCase(username.trim());
    }
}
