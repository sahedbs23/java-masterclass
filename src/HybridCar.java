public class HybridCar extends Car{
    private double avgKlPerLitre;
    private int cylinder;
    private int batterySize;

    public HybridCar(String description, double avgKlPerLitre, int cylinder, int batterySize) {
        super(description);
        this.avgKlPerLitre = avgKlPerLitre;
        this.cylinder = cylinder;
        this.batterySize = batterySize;
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("Driving my hybrid car with %f speed per kilo meter", avgKlPerLitre);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Stating my hybrid car engine");
    }

    @Override
    public void runEngine() {
        super.runEngine();
        System.out.printf("Running engine using %d battery %d cylinder size", batterySize, cylinder);
    }
}
