package barista.condiments;

public class CocoaPowder extends Condiment {
    public Float cost() {
        return 0.4F;
    }

    @Override
    public String getDescription() {
        return "Cocoa Powder!";
    }
}
