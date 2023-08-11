package dev.Generics.challenge;

public interface Mappable {

    void render();

    static double[] stringToLatLong(String locationString){
        String[] latLong = locationString.split(",");
        double lat = Double.parseDouble(latLong[0]);
        double lan = Double.parseDouble(latLong[1]);
        return new double[]{lat,lan};
    };
}
