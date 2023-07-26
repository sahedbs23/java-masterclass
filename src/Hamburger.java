public class Hamburger {
    private String name;
    private String meat;
    private String breadRollType;
    private double price;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat,double price, String breadRollType){
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
    }

    public void addHamburgerAddition1(String name, double price){
        this.addition1Name = name;
        this.addition1Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public void addHamburgerAddition2(String name, double price){
        this.addition2Name = name;
        this.addition2Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }


    public void addHamburgerAddition3(String name, double price){
        this.addition3Name = name;
        this.addition3Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }


    public void addHamburgerAddition4(String name, double price){
        this.addition4Name = name;
        this.addition4Price = price;
        System.out.printf("Added %s for an extra %f%n", name, price);
    }

    public double itemizeHamburger(){
        double additionPrice1 = addition4Name != null ? addition4Price : 0 ;
        double additionPrice2 =      addition3Name != null ? addition3Price : 0 ;
        double additionPrice3 = addition2Name != null ? addition2Price : 0 ;
        double additionPrice4 = addition1Name != null ? addition1Price : 0;

        return price + additionPrice1 + additionPrice2 + additionPrice3 + additionPrice4;
    }



}