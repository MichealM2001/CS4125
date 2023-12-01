import States.CarContext;

public class Car {
    private int yearOfReg;
    private String model;
    private int price;
    private CarContext carContext;
    private String classification;

    public Car(int yearOfReg, String model, int price, String classification) {
        this.yearOfReg = yearOfReg;
        this.model = model;
        this.price = price;
        this.carContext = new CarContext();
        this.classification = classification;
    }

    // Getter and setter methods for the car details go here
    // Getter methods
    public int getYearOfReg() {
        return yearOfReg;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void rent(){
        carContext.rentCar();
    }

    public void returnCar(){
        carContext.returnCar();
    }

    public String getClassification() {
        return classification;
    }

    // Setter methods
    public void setYearOfReg(int yearOfReg) {
        this.yearOfReg = yearOfReg;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

  

    public void setClassification(String classification) {
        this.classification = classification;
    }
}