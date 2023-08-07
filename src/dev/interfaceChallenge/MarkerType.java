package dev.interfaceChallenge;

public enum MarkerType {
    CIRCLE("CIRCLE"),DIAMOND("DIAMOND");
    private final String type;

    MarkerType(String type) {
        this.type = type;
    }

    public String getMarkerType(){
        return type;
    }
}
