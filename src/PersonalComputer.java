public class PersonalComputer extends Product{
    private Monitor monitor;
    private ComputerCase computerCase;
    private Motherboard motherboard;

    public PersonalComputer(String model, String manufacturer,
                            Monitor monitor,
                            ComputerCase computerCase,
                            Motherboard motherboard) {
        super(model, manufacturer);
        this.monitor = monitor;
        this.computerCase = computerCase;
        this.motherboard = motherboard;
    }

    private void showLogo(){
        this.monitor.drawPixel(27,14,"Green");
    }
    public void powerUp(){
        this.computerCase.pressPowerButton();
        this.showLogo();
    }

//    public Monitor getMonitor() {
//        return monitor;
//    }
//
//    public ComputerCase getComputerCase() {
//        return computerCase;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
}
