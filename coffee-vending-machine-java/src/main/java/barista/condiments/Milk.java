package barista.condiments;

public class Milk extends Condiment {

    @Override
    public String getDescription() {
        return "Milk";
    }

    public Float cost() {
        return 0.5F;
    }
}
