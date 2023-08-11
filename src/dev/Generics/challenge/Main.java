package dev.Generics.challenge;

public class Main {
    public static void main(String[] args) {
        var majorRivers = new River[]{
                new River("Padma", "89.123123123,23.9834343", "91.123123123,24.9834545", "92.123123123,25.9834545"),
                new River("Megna", "90.123123321,24.9834343", "91.123123123,25.9834545", "92.123123123,26.9834545"),
                new River("Jamuna", "90.123123321,24.9834343", "91.123123123,25.9834545", "92.123123123,26.9834545"),
                new River("Bramopotro", "90.123123321,24.9834343", "91.123123123,25.9834545", "92.123123123,26.9834545")
        };

        Layer<River> riverLayer = new Layer<>(majorRivers);
        riverLayer.renderLayer();

        var nationalParks = new Park[]{
                new Park("Romna", "23.56586,91.4545"),
                new Park("Botanical Gurden", "23.56586,91.4545"),
        };
        Layer<Park> parkLayer = new Layer<>(nationalParks);

        parkLayer.addElements(
                new Park("Sundarbon", "23.343,91.012"),
                new Park("Unknown", "23.343,91.012")
        );
        parkLayer.renderLayer();
    }
}
