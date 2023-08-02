package dev.sahedmoral.linklist.LinkListChallenge;

public class City {
    private String town;
    private int distance;

    public City(String town, int distance){
        this.town =town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }
}
