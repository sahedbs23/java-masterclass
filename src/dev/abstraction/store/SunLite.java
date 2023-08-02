package dev.abstraction.store;

public class SunLite extends ProductsForSale{
    public SunLite(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("SunLite Lighter");
        System.out.printf("Product type: %s %n Price: %.2f%n Description: %n %s%n", type,getPrice(), getDescription());
    }
}
