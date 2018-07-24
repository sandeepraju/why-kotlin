package barista;

import barista.coffee.HouseBlend;

public class Test {
    public static void main(String[] args){
        Beverage beverage = new HouseBlend.Builder().build();

        System.out.println(beverage.getDescription());
    }
}
