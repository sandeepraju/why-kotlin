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
        switch (type){
            case ESPRESSO: {
                Espresso.Builder builder = new Espresso.Builder();

                if (hasMilk) builder.milk();
                if (hasSyrup) builder.syrup();
                if (hasSugar) builder.sugar();

                return builder.build();
            }
            case HOUSE_BLEND: {
                HouseBlend.Builder builder = new HouseBlend.Builder();

                if (hasMilk) builder.milk();
                if (hasSyrup) builder.syrup();
                if (hasSugar) builder.sugar();

                return builder.build();
            }
            // Note: no compile time checking of branches
            default: {
                throw new IllegalArgumentException("Incorrect choice provided!");
            }
        }
    }
}
