package dev.interfaceChallenge;


import java.lang.reflect.Field;

public interface Mappable {
    public static final String JSON_PROPERTY = """
            "properties": {%s}
            """;
    String label();
    GeometryType mapType();

    String mapMarker();

    default void toJson(){
        String str = """
                "type" : "
                """;
        str  += mapType().getGeometryType();
        str += """
                ",
                """;

        str += """
                "label" : "
                """;
        str  += label();
        str += """
                ",
                """;

        str += """
                "marker" : "
                """;
        str  += mapMarker();
        str += """
                ",
                """;
        System.out.printf(JSON_PROPERTY, str);
    }

    static void show(Mappable map) throws NoSuchFieldException {
        String str = """
                "type" : "
                """;
        str  += map.mapType().getGeometryType();
        str += """
                ",
                """;

        str += """
                "label" : "
                """;
        str  += map.label();
        str += """
                ",
                """;

        str += """
                "marker" : "
                """;
        str  += map.mapMarker();
        str += """
                ",
                """;
        System.out.printf(JSON_PROPERTY, str);

        Field[] fields = map.getClass().getFields();
        for (Field field: fields){
            str += """
                "
                """;
            str += field.getName();
            str += """
                " : "
                """;
            str  += String.valueOf(map.getClass().getField(field.getName()));
            str += """
                ",
                """;
            System.out.printf(JSON_PROPERTY, str);
        }
    }
}
