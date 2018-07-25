package barista;

public abstract class Beverage {
    private final String description = "Beverage!";

    public String getDescription() {
        return description;
    }

    public abstract Float cost();
}
