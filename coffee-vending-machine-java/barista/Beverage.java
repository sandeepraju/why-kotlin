package barista;

public abstract class Beverage {
    String description = "Beverage!";

    public String getDescription() {
        return description;
    }

    public abstract Float cost();
}
