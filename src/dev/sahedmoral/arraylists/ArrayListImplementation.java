package dev.sahedmoral.arraylists;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name, "DAIRY",1);
    }

    @Override
    public String toString() {
        System.out.printf("%d %s in %s%n", count, name, type);
        return null;
    }
}
public class ArrayListImplementation {
    public static void main(String[] args) {
        Object[] objects = new Object[3];
        objects[0] = new GroceryItem("Yogurt");
        objects[1] = new GroceryItem("Apple", "FRUITS", 6);
        objects[2] = "Another Grocery Item";

        System.out.println(Arrays.toString(objects));
        System.out.println("-".repeat(20));


        ArrayList arrLists = new ArrayList();
        arrLists.add(new GroceryItem("Orange", "Fruits", 6));
        arrLists.add("Another ArrayLists Item");
        System.out.println(arrLists);
        System.out.println("-".repeat(20));

        ArrayList<GroceryItem> groceryItems = new ArrayList<>();
        groceryItems.add(new GroceryItem("Orange", "Fruits", 6));
        groceryItems.add(new GroceryItem("Apple", "PRODUCE", 6));
        groceryItems.add(new GroceryItem("Banana", "PRODUCE", 12));
        groceryItems.remove(0);
//        groceryItems.set(0,new GroceryItem("Pomegranate"));


        System.out.println(groceryItems);
        System.out.println("-".repeat(20));


    }
}
