public class Burger {
    private String type;
    private double price;
    private int toppings;

    public Burger(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addToppings(int toppings) {
        this.toppings = Math.min(this.toppings + Math.min(toppings, 3), 3);
    }

    public double getBurgerPrice(){
        return price  + (toppings * (price / 100) * 10);
    }

    public int getToppings() {
        return toppings;
    }
}
