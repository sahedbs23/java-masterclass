public class Monitor extends Product {
    private int size;
    private String resolution;

    public Monitor(String model, String manufacturer, int size, String resolution) {
        super(model, manufacturer);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixel(int x, int y, String color){
        System.out.printf("Drawing pixel in %d %d %s%n", x, y, color);
    }
}
