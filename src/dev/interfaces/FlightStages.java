package dev.interfaces;

public enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;
    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println(this + " monitoring");
        }
    }

    public FlightStages nextStage(){
        FlightStages[] flightStages = values();
        return flightStages[ (ordinal() + 1) % flightStages.length];
    }
}
