package Main;

public class MainController {

     private MainModel mainModel;

    public MainController(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public boolean checkLoginStatus() {
        return mainModel.isLoggedIn();

    }
}



   

