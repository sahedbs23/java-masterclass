public class Drink {
    private String type;
    private char size;
    protected double prize;

    public Drink(){
        this("Coca-cola", 's');
    }

    public Drink(String type, char size) {
        this.type = type;
        this.setSize(size);
    }

    public void setSize(char size){
        this.size = size;
        switch (size){
            case 'm' , 'M' -> this.prize = 30;
            case 'l', 'L' -> this.prize = 45;
            default ->  this.prize = 15;
        }
    }

    public double getPrize() {
        return prize;
    }
}
