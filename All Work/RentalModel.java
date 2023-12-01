public class RentalModel {
    private String carName;
    private double pricePerDay;
    private int availability;
    private int carYear;

    public RentalModel(String carName, double pricePerDay, int availability, int carYear) {
        this.carName = carName;
        this.pricePerDay = pricePerDay;
        this.availability = availability;
        this.carYear = carYear;
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

        public int getCarYear() {
        return carYear;
    }

public void decreaseAvailability() {
    // Assuming availability is an instance variable in CarModel
   
        availability--;
       
    }
}


