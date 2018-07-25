package barista;

public class CoffeeVendor {
    private static volatile CoffeeVendor vendor;

    private CoffeeVendor() {
    }

    public static CoffeeVendor getInstance() {
        if (vendor == null) {
            synchronized (CoffeeVendor.class) {
                if (vendor == null) {
                    vendor = new CoffeeVendor();
                }
            }
        }
        return vendor;
    }

    public Beverage serverCoffee(CoffeeType type, Boolean hasMilk, Boolean hasSyrup, Boolean hasSugar) {
        return CoffeeFactory.getInstance().serverCoffee(type, hasMilk, hasSyrup, hasSugar);
    }
}
