package dev.abstraction.store;

public class SamsungNoteTen extends ProductsForSale{
    public SamsungNoteTen(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("Samsung note 10 smart phone");
        System.out.printf("Product type: %s %n Price: %.2f%n Description: %n %s%n", type,getPrice(), getDescription());
    }
}
