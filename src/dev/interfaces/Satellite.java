package dev.interfaces;

public class Satellite implements OrbitEarth {
    FlightStages flightStages = FlightStages.GROUNDED;
    @Override
    public void takeOff() {
        transition("taking off");
    }

    @Override
    public void land() {
        achieveOrbit();
        transition("landing");
    }

    @Override
    public void fly() {
        transition("flying");
    }

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved");
    }

    public void transition(String description){
        System.out.println(description);
        flightStages = transition(flightStages);
        flightStages.track();
    }
}
