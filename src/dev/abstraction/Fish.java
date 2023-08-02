package dev.abstraction;

import java.util.Objects;

public class Fish extends Animal{
    public Fish(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (Objects.equals(speed, "slow")){
            System.out.print("swimming slowly ");
        }else {
            System.out.print("Swimming to fast ");
        }
    }

    /**
     *
     */
    @Override
    public void makeNoise() {
        if (Objects.equals(type, "GoldFish")){
            System.out.println(getExplicitClass() + "Chic Chic ");
        }else {
            System.out.println(getExplicitClass() + "So su su ");
        }
    }
}
