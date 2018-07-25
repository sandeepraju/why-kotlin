package barista;

import barista.coffee.Espresso;
import barista.coffee.HouseBlend;

public class CoffeeFactory {
    private CoffeeFactory() {
    }

    private static volatile CoffeeFactory factory;

    public static CoffeeFactory getInstance() {
        if (factory == null) {
            synchronized (CoffeeFactory.class) {
                if (factory == null) {
                    factory = new CoffeeFactory();
                }
            }
        }
        return factory;
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
