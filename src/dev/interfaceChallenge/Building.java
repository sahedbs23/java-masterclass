package dev.interfaceChallenge;

public class Building implements Mappable{
    private String label;
    private String markerType;
    private GeometryType mapType;

    private String name;
    private String usage;

    public Building(String name, String usage) {
        this.name=name;
        this.usage=usage;
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

    public String getLabel() {
        return label;
    }

    public String getMarkerType() {
        return markerType;
    }

    public GeometryType getMapType() {
        return mapType;
    }

    @Override
    public String toJson() {
        return """
                "type": "%s", "label": "%s", "marker": "%s", "name": "%s", "usages": "%s" """.formatted( mapType,label, markerType, name,usage);
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
