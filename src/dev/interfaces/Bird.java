package dev.interfaces;

public class Bird extends Animal implements FlightEnabled{
    @Override
    public void move(String speed) {
        System.out.printf("%s Moving %s%n", getClassName(),speed);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s can make sound! %n",getClassName());
    }

    @Override
    public void takeOff() {
        System.out.printf("%s is taking off %n",getClassName());
    }

    @Override
    public void land() {
        System.out.printf("%s is landing %n",getClassName());
    }

    @Override
    public void fly() {
        System.out.printf("%s is flying. %n",getClassName());
    }

    private String getClassName(){
        return getClass().getSimpleName();
    }
}
