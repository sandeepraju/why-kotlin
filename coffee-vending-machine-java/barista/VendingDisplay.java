package barista;

import java.util.Scanner;

public class VendingDisplay {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeVendor vendor = CoffeeVendor.getInstance();
        keepServing(vendor);
    }

    private static void keepServing(CoffeeVendor vendor) {
        while (true) {
            System.out.println("Make a choice for coffee 1. House Blend 2. Espresso - Any other key for exit");
            String choice = scanner.nextLine();
            if ("1".equals(choice.trim())) {
                Beverage beverage = vendor.serverCoffee(CoffeeType.HOUSE_BLEND, milkNeeded(), syrupNeeded(), sugarNeeded());
                System.out.println("Serving " + beverage.getDescription() + " Total cost = " + beverage.cost());
            } else if ("2".equals(choice.trim())) {
                Beverage beverage = vendor.serverCoffee(CoffeeType.ESPRESSO, milkNeeded(), syrupNeeded(), sugarNeeded());
                System.out.println("Serving " + beverage.getDescription() + " Total cost = " + beverage.cost());
            } else {
                System.out.println("Terminating...");
                System.exit(0);
            }
        }
    }

    public static boolean milkNeeded() {
        System.out.println("Do you want to add milk? (y/n)");
        return "y".equals(scanner.nextLine().trim());
    }

    public static boolean syrupNeeded() {
        System.out.println("Do you want to add flavored syrup? (y/n)");
        return "y".equals(scanner.nextLine().trim());
    }

    public static boolean sugarNeeded() {
        System.out.println("Do you want to add sugar? (y/n)");
        return "y".equals(scanner.nextLine().trim());
    }

}
