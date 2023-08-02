package dev.abstraction.store;

import java.util.ArrayList;

public class Store {
    private static ArrayList<ProductsForSale> productsForSales;
    private static ArrayList<OrderItem> orderItems;
    public static void main(String[] args) {
        productsForSales = new ArrayList<>();
        orderItems = new ArrayList<>();
        addProducts();
        showProducts();
        addToCheckout(new OrderItem(1,productsForSales.get(0)));
        addToCheckout(new OrderItem(2,productsForSales.get(2)));
        addToCheckout(new OrderItem(3,productsForSales.get(4)));

        System.out.println("-".repeat(30));
        printOrderItems();
    }

    public static void addProducts(){
       addToStore(new MacBookPro("Laptop", 1200, """
                MacBook Pro with 8gb RAM
                """));

       addToStore(new MacBookPro("Laptop", 1600, """
                MacBook Pro with 16gb RAM
                """));

        addToStore(new SamsungNoteTen("phone", 600, """
                Samsung Note 10 with 16 GB RAM
                """));


        addToStore(new SamsungNoteTen("phone", 400, """
                Samsung Note 10 with 8 GB RAM
                """));

        addToStore(new SunLite("lighter", 10, """
                Sun Lite lighter
                """));


    }

    public static void showProducts(){
        for (ProductsForSale product : productsForSales){
            product.showDetails();
        }
    }

    public static void addToStore(ProductsForSale product){
        productsForSales.add(product);
    }

    public static boolean addToCheckout(OrderItem product){
        return orderItems.add(product);
    }

    public static void printOrderItems(){
        double total = 0;
        for (OrderItem orderItem: orderItems){
            total += orderItem.getProduct().getSalesPrice(orderItem.getQuantity());
            orderItem.getProduct().printPrice(orderItem.getQuantity());
        }
        System.out.printf("Total = %.2f", total);
    }
}
