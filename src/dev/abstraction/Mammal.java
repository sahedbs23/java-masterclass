package dev.abstraction;

public abstract class Mammal extends Animal {
    public Mammal(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        System.out.println("Making noise");
    }

    public abstract void headShark();
}
