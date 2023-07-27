package dev.sahedmoral.arraylistchallenage;

import java.util.Scanner;

public class ShoppingCartManager {
    private final Scanner scanner;
    private final ShoppingManager shoppingManager;
    public ShoppingCartManager(){
        shoppingManager = new ShoppingManager();
        scanner = new Scanner(System.in);
    }

    public void browseProduct(){
        String catalog = """
                Available actions:
                0 -  to shutdown the program
                1 - to add item(s) to the lists, Comma delimited lists
                2 - to remove item(s) from lists, comma delimited lists
                Enter a number for which action you want to do
                """;
        boolean loop = true;
        while (loop){
            System.out.println(catalog);
            String userInput = scanner.nextLine();
            switch (Integer.parseInt(userInput)){
                case 1 -> addToCart();
                case 2 -> removeFromCart();
                default -> loop = false;
            }

        }
    }

    private void addToCart(){
        System.out.println("Enter Comma delimited grocery items you want to add");
        String groceryItemRemove = scanner.nextLine();
        String[] removingLists= groceryItemRemove.split(",");
        for (String item : removingLists) {
            if (shoppingManager.addToShoppingCart(item)){
                System.out.println("Added to cart");
            }
        }
        shoppingManager.printCart();
    }

    private void removeFromCart(){
        System.out.println("Enter Comma delimited grocery items you want to remove");
        String groceryItemRemove = scanner.nextLine();
        String[] removingLists= groceryItemRemove.split(",");
        for (String item : removingLists) {
            if (shoppingManager.removeFromCart(item)){
                System.out.println("removed from cart");
            }
        }
        shoppingManager.printCart();
    }


}
