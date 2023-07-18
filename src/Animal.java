public class Animal {
    private String type;
    private String size;
    private double weight;

    public Animal(){

    }

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speed){
        System.out.println(this.type + " move " + speed);
    }
    public void makeNoise(){
        System.out.println(this.type +" make some kins of noise");
    }
}
