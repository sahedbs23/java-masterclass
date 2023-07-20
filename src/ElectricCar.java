public class ElectricCar extends Car{
    private double avgKmPerBattery;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerBattery, int batterySize) {
        super(description);
        this.avgKmPerBattery = avgKmPerBattery;
        this.batterySize = batterySize;
    }


    @Override
    public void drive() {
        super.drive();
        System.out.printf("Driving my electric  car with %f speed per kilo meter", avgKmPerBattery);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Stating my electric car engine");
    }

    @Override
    public void runEngine() {
        super.runEngine();
        System.out.printf("Running engine using %d battery", batterySize);
    }
}
