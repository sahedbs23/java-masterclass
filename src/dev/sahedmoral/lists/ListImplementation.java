package dev.sahedmoral.lists;

import java.util.ArrayList;
import java.util.List;

public class ListImplementation {
    public static void main(String[] args) {
        String[] items = {"Apple", "Banana", "Fish", "Meat"};

        List<String> groceryLists = List.of(items);
        System.out.println(groceryLists);

        ArrayList<String> groceryArrList = new ArrayList<>(groceryLists);
        groceryArrList.add("Milk");
        System.out.println(groceryArrList);

        ArrayList<String> newArrList = new ArrayList<>(List.of("Spinach", "potato", "Tomato"));
        newArrList.addAll(groceryArrList);
        System.out.println(newArrList);


    }
}
