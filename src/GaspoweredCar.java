public class GaspoweredCar extends Car{
    private double avgKmPerLiter;
    private int cylinders;

    public GaspoweredCar(String description, double avgKmPerLiter, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("Driving my gas powered car with %f speed per kilo meter", avgKmPerLiter);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Stating engine using gas");
    }

    @Override
    public void runEngine() {
        super.runEngine();
        System.out.printf("Running engine using %d", cylinders);
    }
}
