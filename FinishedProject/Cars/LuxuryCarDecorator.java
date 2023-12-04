package Cars;

// LuxuryCarDecorator class extends the functionality of CarDecorator
public class LuxuryCarDecorator extends CarDecorator {

    // Constructor for LuxuryCarDecorator
    public LuxuryCarDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    // Overriding the getPrice method to include the cost of luxury features
    @Override
    public int getPrice() {
        // Fixed additional cost for luxury features. 
        int luxuryFeatureCost = 5000;

        // Return the original price plus the additional luxury feature cost
        return decoratedCar.getPrice() + luxuryFeatureCost;
    }

    public String getLuxuryFeatures() {
        // Return a string describing the luxury features
        return "Premium leather interior, advanced infotainment system, enhanced safety features";
    }
}
