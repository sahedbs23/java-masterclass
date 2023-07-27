package dev.sahedmoral.arraylistchallenage;

import java.util.ArrayList;

public class ShoppingManager {
    private final ArrayList<String> shoppingLists;

    public ShoppingManager(){
        shoppingLists = new ArrayList<>();
    }

    public void printCart(){
        System.out.println(shoppingLists);
    }

    public boolean removeFromCart(String product){
        int indexOf = shoppingLists.indexOf(product);
        if (indexOf < 0){
            return false;
        }
        return shoppingLists.remove(product);
    }
    public boolean addToShoppingCart(String product){
        int indexOf = shoppingLists.indexOf(product);
        if (indexOf >= 0){
            return false;
        }
        return shoppingLists.add(product);
    }

}
