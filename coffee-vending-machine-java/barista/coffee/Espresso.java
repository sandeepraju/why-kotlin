package barista.coffee;

import barista.Beverage;
import barista.condiments.CocoaPowder;
import barista.condiments.FlavoredSyrup;
import barista.condiments.Milk;
import barista.condiments.Sugar;

public class Espresso extends Beverage {

    public Milk milk;
    public Sugar sugar;
    public FlavoredSyrup syrup;

    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    public Float cost() {
        Float total = 3.50F;
        if(milk != null) total += milk.cost();
        if(sugar != null) total += sugar.cost();
        if(syrup != null) total += syrup.cost();
        return total;
    }

    private Espresso() {
    }

    public static class Builder {

        public Milk milk;
        public Sugar sugar;
        public FlavoredSyrup syrup;

        public Builder() {}

        public Builder milk(){
            this.milk = new Milk();
            return this;
        }

        public Builder sugar(){
            this.sugar = new Sugar();
            return this;
        }

        public Builder syrup(){
            this.syrup = new FlavoredSyrup();
            return this;
        }

        public Espresso build() {
            Espresso coffee = new Espresso();
            coffee.milk = this.milk;
            coffee.sugar = this.sugar;
            coffee.syrup = this.syrup;
            return coffee;
        }
    }
}
