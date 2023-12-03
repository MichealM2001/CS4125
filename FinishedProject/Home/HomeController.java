package Home;

public class HomeController {
    private HomeView homeView;
    private HomeModel homeModel = new HomeModel();
    
    public HomeController(HomeView homeView){
        this.homeView = homeView;
    }

    public void goToUser(){
        homeModel.goToUser(homeView);
    }

    

}
