package dev.Generics.challenge;

import java.util.Arrays;

abstract public class Point implements Mappable{
    private double[] location;

    public Point( String location) {
            this.location = Mappable.stringToLatLong(location);
    }
    public void render() {
        System.out.println("Render "+this+" as POINT ("+location()+")");
    }

    private String location(){
        return Arrays.toString(location);
    }
}
