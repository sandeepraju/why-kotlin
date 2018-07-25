package barista;

import barista.coffee.Espresso;
import barista.coffee.HouseBlend;

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
        if (type.equals(CoffeeType.ESPRESSO)) {
            Espresso.Builder builder = new Espresso.Builder();

            if (hasMilk) builder = builder.milk();
            if (hasSyrup) builder = builder.syrup();
            if (hasSugar) builder = builder.sugar();

            return builder.build();
        } else if (type.equals(CoffeeType.HOUSE_BLEND)) {
            HouseBlend.Builder builder = new HouseBlend.Builder();

            if (hasMilk) builder = builder.milk();
            if (hasSyrup) builder = builder.syrup();
            if (hasSugar) builder = builder.sugar();

            return builder.build();
        } else {
            throw new IllegalArgumentException("Incorrect choice provided!");
        }
    }
}
