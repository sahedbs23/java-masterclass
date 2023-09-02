package dev.lpa.CardChelleange;

public record Card(Suit suit, String face,int rank) {
    @Override
    public String toString() {
        return "%s%c(%d)".formatted(face,suit.getImage(),rank);
    }

    public static Card getNumericCard(Suit suit, int index){
        return new Card(suit,String.valueOf(index),index);
    }

    public static Card getFaceCard(Suit suit, char c, int rank){
        return new Card(suit,String.valueOf(c),rank);
    }

    public static Card getFaceCard(Suit suit, String c, int rank){
        return new Card(suit,c,rank);
    }
}
