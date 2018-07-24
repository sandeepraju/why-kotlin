package barista.condiments;

public class FlavoredSyrup extends Condiment {

    public Float cost() {
        return 0.3F;
    }

    @Override
    public String getDescription() {
        return "Flavored Syrup!";
    }
}
