package dev.interfaceChallenge;

public enum GeometryType {
    LINE("LINE"),POINT("POINT");
    private final String type;

    GeometryType(String type) {
        this.type = type;
    }

    public String getGeometryType(){
        return type;
    }
}
