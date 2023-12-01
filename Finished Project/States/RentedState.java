package States;

public class RentedState implements CarState {
    @Override
    public void rentCar(CarContext carContext){

    }

    @Override
    public void returnCar(CarContext carContext){
        carContext.setState(new AvailableState());
    }

    @Override
    public void repairCar(CarContext carContext) {
        

    }
}
