package dev.abstraction.store;

public class OrderItem {
    private int quantity;
    private ProductsForSale product;

    public OrderItem(int quantity, ProductsForSale product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductsForSale getProduct() {
        return product;
    }
}
