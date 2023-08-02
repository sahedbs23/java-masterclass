package dev.abstraction.store;

public abstract class ProductsForSale {
    protected String type;
    private double price;
    private String description;

    public ProductsForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity){
        return price * quantity;
    }

    public void printPrice(int quantity){
        System.out.printf("Quantity = %d %.2f%n",quantity, getSalesPrice(quantity));
    }

    public abstract void showDetails();

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
