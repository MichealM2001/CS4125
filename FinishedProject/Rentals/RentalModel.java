package Rentals;
public class RentalModel {
    private String carName;
    private double pricePerDay;
    private boolean availability;

    public RentalModel(String carName, double pricePerDay, boolean availability) {
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

    public Boolean getAvailability() {
        return availability;
    }

    public void changeAvailability(Boolean available){
        availability = available;
    }
// public void decreaseAvailability() {
//     
   
//         availability--;
       
//     }
}


