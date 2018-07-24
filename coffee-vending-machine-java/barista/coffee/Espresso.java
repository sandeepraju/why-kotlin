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
    public CocoaPowder powder;

    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    public Float cost() {
        return 3.50F;
    }

    private Espresso() {
    }

    public static class Builder {

        public Milk milk;
        public Sugar sugar;
        public FlavoredSyrup syrup;
        public CocoaPowder powder;

        public Builder() {}

        public Builder milk(Milk milk){
            this.milk = milk;
            return this;
        }

        public Builder sugar(Sugar sugar){
            this.sugar = sugar;
            return this;
        }

        public Builder syrup(FlavoredSyrup syrup){
            this.syrup = syrup;
            return this;
        }

        public Builder powder(CocoaPowder powder){
            this.powder = powder;
            return this;
        }

        public Espresso build() {
            Espresso coffee = new Espresso();
            coffee.milk = this.milk;
            coffee.sugar = this.sugar;
            coffee.syrup = this.syrup;
            coffee.powder = this.powder;
            return coffee;
        }
    }
}
