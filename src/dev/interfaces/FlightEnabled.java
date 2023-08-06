package dev.interfaces;

public interface FlightEnabled {
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();
    void land();
    void fly();

    default FlightStages transition(FlightStages stages){
        FlightStages nextStage = stages.nextStage();
        System.out.println(getClass().getName() + " is transitioning from " + stages  +" to "+ nextStage);
        return nextStage;
    }
}
