package Cars;

import Cars.CarDecorator;
import Cars.Car;

public class GPSDecorator extends CarDecorator {
    private final int gpsCost = 500; // Additional cost for GPS

    public GPSDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + gpsCost;
    }

    
}
