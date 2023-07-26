public class ExtraFoodItem {
    private String type;
    private double price;

    public ExtraFoodItem() {
        this("French Fried",5.20);
    }

    public ExtraFoodItem(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
