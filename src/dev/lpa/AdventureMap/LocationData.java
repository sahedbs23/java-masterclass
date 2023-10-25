package dev.lpa.AdventureMap;

import java.util.*;

public class LocationData {

    private static String data = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    public static Map<String, Location> getLocationData(){
        Scanner scanner = new Scanner(data);
        Map<String, Location> locations = new HashMap<>();
        Map<String,String[]> nextLocations = new HashMap<>();

        while (scanner.hasNext()){
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.split(",");
            String key = strings[0].trim();
            Location location = new Location(key, strings[1].trim());
            locations.put(key,location);
            nextLocations.put(key,Arrays.copyOfRange(strings,2,strings.length));
        }

        locations.forEach((k,v) -> {
            var s = nextLocations.get(k);
            for (var key:s) {
                String[] lmap = key.split(":");
                v.addNextLocation(Direction.valueOf(lmap[0].trim()),locations.get(lmap[1].trim()));
            }
        });
        return locations;
    }
}
