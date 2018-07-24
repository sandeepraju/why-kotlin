package barista.coffee;

import barista.Beverage;
import barista.condiments.FlavoredSyrup;
import barista.condiments.Milk;
import barista.condiments.Sugar;

public class HouseBlend extends Beverage {

    public Milk milk;
    public Sugar sugar;
    public FlavoredSyrup syrup;

    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    public Float cost() {
        return 3.50F;
    }

    private HouseBlend() {
    }

    public static class Builder {

        public Milk milk;
        public Sugar sugar;
        public FlavoredSyrup syrup;

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

        public HouseBlend build() {
            HouseBlend coffee = new HouseBlend();
            coffee.milk = this.milk;
            coffee.sugar = this.sugar;
            coffee.syrup = this.syrup;
            return coffee;
        }
    }
}
