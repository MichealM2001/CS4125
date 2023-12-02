package Cars;

public abstract class CarDecorator extends Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        super(decoratedCar.getYearOfReg(), decoratedCar.getModel(), 
              decoratedCar.getPrice(), decoratedCar.getClassification());
        this.decoratedCar = decoratedCar;
    }

    // Overriding the getPrice method to allow for additional cost
    @Override
    public int getPrice() {
        return decoratedCar.getPrice();
    }
}