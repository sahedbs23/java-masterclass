package dev.interfaceChallenge;


public interface Mappable {
    public static final String JSON_PROPERTY = """
            "properties": {%s}
            """;
    String label();
    GeometryType mapType();

    String mapMarker();

    default String toJson(){
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted( mapType(),label(), mapMarker());
    }

    static void show(Mappable map){
        System.out.printf(JSON_PROPERTY.formatted(map.toJson()));
    }
}
