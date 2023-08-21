package dev.lpa.Burget;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    private double conversationRate;

    enum Topping {
        CHESS("Chess",.75), TOMATO("Tomato",0), BREAD("Bread",.50), MEAT("Meat",2.00);
        private final String name;
        private final double price;
        Topping(String name,double price){
            this.name = name;
            this.price = price;
        }

    }

    public Meal() {
        this(1);
    }

    public Meal(double conversationRate) {
        this.conversationRate = conversationRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    public void AddTopping(Topping topping){
        burger.addTopping(topping.name,topping.price);
    }

    public double getTotal(){
        return Item.getPrice(burger.totalPrice() + drink.price + side.price,conversationRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%27s$%.2f%n".formatted(burger,drink,side,"Total Due: ",getTotal());
    }


    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name,type,"burger".equals(type) ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s %15s $%.2f".formatted(name,type,getPrice(price,conversationRate));
        }

        static double getPrice(double price, double rate){
            return price * rate;
        }
    }

    class Burger extends Item{

        private List<Item> toppings = new ArrayList<>();

        public Burger(String name) {
            super(name, "burger");
        }
        private void addTopping(String name, double price){
            toppings.add(new Item(name,"topping", price));
        }
        private double totalPrice(){
            double totalPrice = super.price;
            for (Item topping: toppings){
                totalPrice += topping.price;
            }
            return getPrice(totalPrice, conversationRate);
        }

        @Override
        public String toString() {
            StringBuilder toppingsDesc = new StringBuilder();
            for (Item topping: toppings){
                toppingsDesc.append("\n");
                toppingsDesc.append(topping.toString());
            }
            return toppingsDesc.toString();
        }
    }

}
