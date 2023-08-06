package dev.interfaceChallenge;

public class Building implements Mappable{
    private String label;
    private String markerType;
    private GeometryType mapType;

    public String name;
    public String usage;

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
