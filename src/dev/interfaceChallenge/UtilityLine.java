package dev.interfaceChallenge;

public class UtilityLine implements Mappable{
    private String label;
    private String markerType;
    private GeometryType mapType;

    public String name;
    public String utility;

    public UtilityLine(String name, String utility) {
        this.name=name;
        this.utility =utility;
    }
    @Override
    public String label() {
        return label;
    }

    @Override
    public GeometryType mapType() {
        return mapType;
    }

    @Override
    public String mapMarker() {
        return markerType;
    }

    @Override
    public String toJson() {
        return """
                "type": "%s", "label": "%s", "marker": "%s", "name": "%s", "utility": "%s" """.formatted( mapType,label, markerType, name,utility);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setMarkerType(String markerType) {
        this.markerType = markerType;
    }

    public void setMapType(GeometryType mapType) {
        this.mapType = mapType;
    }
}
