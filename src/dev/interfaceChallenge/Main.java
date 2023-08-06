package dev.interfaceChallenge;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Building building = new Building("Sydney Town hall", "GOVERNMENT");
        building.setLabel("Sydney Town hall (GOVERNMENT)");
        building.setMapType(GeometryType.POINT);
        building.setMarkerType("RED STAR");
        building.toJson();
        Mappable.show(building);

//        UtilityLine utilityLine = new UtilityLine("", "");
//        utilityLine.setMapType(GeometryType.LINE);
//
//        utilityLine.toJson();

    }
}
