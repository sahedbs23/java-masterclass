package dev.abstraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Wolf", "Big", 150);
        dog.makeNoise();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "Big", 150));
        animals.add(new Fish("GoldFish", "small", 1));
        animals.add(new Fish("Barracuda", "Big", 75));
        animals.add(new Dog("Pug", "small", 20));
        animals.add(new Horse("Pagla gura", "Big", 1000));

        for (Animal animal : animals ){
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal){
                currentMammal.headShark();
            }
        }
    }

    private static void doAnimalStuff(Animal animal){
        animal.move("slow");
        animal.makeNoise();
    }
}
