package dev.lpa.Model;

public class LpaStudent extends Student{
    private double percentageCompleted;

    public LpaStudent() {
        this.percentageCompleted = random.nextDouble(0.0, 100.001);
    }

    public double getPercentageCompleted() {
        return percentageCompleted;
    }

    @Override
    public String toString() {
        return "%s %.2f".formatted(super.toString(), percentageCompleted);
    }
}
