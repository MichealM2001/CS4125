package States;

public interface CarState {
    void rentCar(CarContext carContext);
    void returnCar(CarContext carContext);
    void repairCar(CarContext carContext);
} 
