package dev.interfaces;

public interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    private void log(String description){
        var today = new java.util.Date();
        System.out.println(today + ": "+ description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + " " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = stage.nextStage();
        logStage(stage, "Beginning transition to " +nextStage);
        return nextStage;
    }
}
