package dev.abstraction;

public class Horse extends Mammal{
    public Horse(String type, String size, int weight) {
        super(type, size, weight);
    }

    /**
     * @param speed
     */
    @Override
    public void move(String speed) {
        System.out.print(" Moving so Fast");
    }

    /**
     *
     */
    @Override
    public void headShark() {
        System.out.println("Head shark in the spring");
    }
}
