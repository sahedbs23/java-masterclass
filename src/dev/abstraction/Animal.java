package dev.abstraction;

public abstract class Animal {
    public String type;
    private String size;
    private int weight;

    public Animal(String type, String size, int weight){
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

    public String getExplicitClass(){
        return getClass().getSimpleName() + " " + type + " ";
    }
}
