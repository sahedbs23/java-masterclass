package dev.abstraction;

import java.util.Objects;

public class Dog extends Animal{
    public Dog(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (Objects.equals(speed, "slow")){
            System.out.print("walking ");
        }else {
            System.out.print("Running ");
        }
    }

    /**
     *
     */
    @Override
    public void makeNoise() {
        if (Objects.equals(type, "wolf")){
            System.out.println(getExplicitClass() + "GeoGeo ");
        }else {
            System.out.println(getExplicitClass() + "Bark ");
        }
    }
}
