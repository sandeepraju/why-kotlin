package barista.condiments;

public class Sugar extends Condiment {
    public Float cost() {
        return 0.1F;
    }

    @Override
    public String getDescription() {
        return "Sugar";
    }
}
