package States;



public class AvailableState implements CarState{
    @Override
    public void rentCar(CarContext carContext){
        carContext.setState(new RentedState());
    }

    @Override
    public void returnCar(CarContext carContext){
        
    }

    @Override
    public void repairCar(CarContext carContext){
        
    }
}
