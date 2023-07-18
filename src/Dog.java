import java.util.Objects;

public class Dog extends Animal{

    private String earShape;
    private String legShape;

    public Dog(String type, String size){
        this(type, size,"curly", "y-shape");
    }

    public Dog(String type, String size, String earShape, String legShape) {
        super(type, size, Objects.equals(size, "small") ? 15 : (Objects.equals(size, "medium") ? 25 : 40));
        this.earShape = earShape;
        this.legShape = legShape;
    }

    public void move(String speed){

    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", legShape='" + legShape + '\'' +
                "} " + super.toString();
    }
}
