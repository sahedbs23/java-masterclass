package dev.abstraction.store;

public class MacBookPro extends ProductsForSale{
    public MacBookPro(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("MacBook Pro Laptop");
        System.out.printf("Product type: %s %n Price: %.2f%n Description: %n %s%n", type,getPrice(), getDescription());
    }
}
