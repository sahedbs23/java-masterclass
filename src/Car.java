public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.printf("Start the %s engine%n", this.getClass().getSimpleName());
    }

    public void drive(){
        System.out.printf("Driving the %s%n", this.getClass().getSimpleName());
    }

    protected void  runEngine(){
        System.out.printf("%s Engine running%n", this.getClass().getSimpleName());
    }
}
