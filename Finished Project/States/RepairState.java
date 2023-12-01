package States;
public class RepairState implements CarState{
    

    @Override
    public void rentCar(CarContext carContext){

    }

    @Override
    public void returnCar(CarContext carContext){
        
    }

    @Override
    public void repairCar(CarContext carContext) {
        carContext.setState(new AvailableState());

    }
}
