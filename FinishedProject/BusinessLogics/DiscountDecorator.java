public interface Discounts {
    double applyDiscount(double price);
}

// Abstract decorator class
public abstract class DiscountDecorator implements Discounts {
    protected Discounts decoratedDiscount;

    public DiscountDecorator(Discounts decoratedDiscount) {
        this.decoratedDiscount = decoratedDiscount;
    }

    public double applyDiscount(double price) {
        return decoratedDiscount.applyDiscount(price);
    }
}

// Concrete Decorator Example
public class SeasonalDiscountDecorator extends DiscountDecorator {
    public SeasonalDiscountDecorator(Discounts decoratedDiscount) {
        super(decoratedDiscount);
    }

    public double applyDiscount(double price) {
        // Assuming a 10% seasonal discount
        return super.applyDiscount(price) * 0.9;
    }
}
