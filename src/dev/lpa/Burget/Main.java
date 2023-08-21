package dev.lpa.Burget;

public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal();
        meal.AddTopping(Meal.Topping.CHESS);
        meal.AddTopping(Meal.Topping.TOMATO);
        meal.AddTopping(Meal.Topping.MEAT);
        meal.AddTopping(Meal.Topping.BREAD);
        System.out.println(meal);

        Meal usMean = new Meal(.68);
        usMean.AddTopping(Meal.Topping.CHESS);
        usMean.AddTopping(Meal.Topping.TOMATO);
        usMean.AddTopping(Meal.Topping.MEAT);
        usMean.AddTopping(Meal.Topping.BREAD);
        System.out.println(usMean);
    }
}
