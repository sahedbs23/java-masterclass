public class Calculator {
    private Floor floor;
    private Carpet carpet;

    private Calculator(Floor floor, Carpet carpet){
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        return this.carpet.getCost() * this.floor.getArea();
    }
}
