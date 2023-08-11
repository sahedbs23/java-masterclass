package dev.Generics.challenge;

import java.util.Arrays;

abstract public class Line implements Mappable{
    private double[][] locations;

    public Line(String... locations) {
        int length = locations.length;
        this.locations = new double[length][2];

        int index = 0;

        for (String location : locations){
            this.locations[index++] = Mappable.stringToLatLong(location);
        }
    }
    public void render() {
        System.out.println("Render "+this+" as LINE ("+location()+")");
    }

    private String location(){
        return Arrays.deepToString(locations);
    }
}
