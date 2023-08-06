package dev.interfaces;

public class Main {
    public static void main(String[] args) {
//
        FlightEnabled satellite = new Jet();
        runFlightEnableFeather(satellite);
    }

    private static void runFlightEnableFeather(FlightEnabled flier){
        flier.land();
        flier.fly();
        flier.takeOff();
    }
}
