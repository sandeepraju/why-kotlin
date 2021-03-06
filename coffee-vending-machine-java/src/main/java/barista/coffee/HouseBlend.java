package barista.coffee;

import barista.Beverage;
import barista.condiments.FlavoredSyrup;
import barista.condiments.Milk;
import barista.condiments.Sugar;

import java.util.Objects;

//Note: final class
final public class HouseBlend extends Beverage {

    private Milk milk;
    private Sugar sugar;
    private FlavoredSyrup syrup;

    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    public Float cost() {
        Float total = 4.50F;
        if(milk != null) total += milk.cost();
        if(sugar != null) total += sugar.cost();
        if(syrup != null) total += syrup.cost();
        return total;
    }

    private HouseBlend() {
    }

    // Note: Builder pattern
    public static class Builder {

        private Milk milk;
        private Sugar sugar;
        private FlavoredSyrup syrup;

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

        public HouseBlend build() {
            HouseBlend coffee = new HouseBlend();
            coffee.milk = this.milk;
            coffee.sugar = this.sugar;
            coffee.syrup = this.syrup;
            return coffee;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HouseBlend)) return false;
        HouseBlend that = (HouseBlend) o;
        return Objects.equals(milk, that.milk) &&
            Objects.equals(sugar, that.sugar) &&
            Objects.equals(syrup, that.syrup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(milk, sugar, syrup);
    }
}
