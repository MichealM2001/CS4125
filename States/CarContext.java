package States;
public class CarContext {
    private CarState state;

    public CarContext(){
        state = new AvailableState();
    }

    public void rentCar(){
        state.rentCar(this);
    }

    public void returnCar(){
        state.returnCar(this);
    }

    public void repairCar(){
        state.repairCar(this);
    }

    public void setState(CarState state){
        this.state = state;
    }

    public CarState getCurrentState(){
        return state;
    }
}
