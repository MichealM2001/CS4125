public class RentalModel {
    private String carName;
    private double pricePerDay;
    private int availability;

    public RentalModel(String carName, double pricePerDay, int availability) {
        this.carName = carName;
        this.pricePerDay = pricePerDay;
        this.availability = availability;
    }

    public String getCarName() {
        return carName;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getAvailability() {
        return availability;
    }

public void decreaseAvailability() {
    // Assuming availability is an instance variable in CarModel
   
        availability--;
       
    }
}


