package dev.lpa.Collections;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage(){
            return (new char[]{9827,9830,9829,9824}[this.ordinal()]);
        }
    }
    @Override
    public String toString() {
        int faceIndex = face.equals("10") ? 2  :1;
        String faceString = face.substring(0,faceIndex);
        return "%s%c(%d)".formatted(faceString,suit.getImage(),rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumber){
        if (cardNumber>1 && cardNumber<11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid card number provided!");
        return null;
    }
    public static Card getFaceCard(Suit suit, char abbreviation){
        int index = "JQKA".indexOf(abbreviation);
        if (index > -1){
            return new Card(suit,""+abbreviation,index+9);
        }
        System.out.println("Invalid face value provide");
        return null;
    }

    public static List<Card> getStandardDeck(){
        List<Card> cards = new ArrayList<>(52);
        for (Suit suit : Suit.values()){
            for (int i = 2; i <= 10; i++) {
                cards.add(getNumericCard(suit,i));
            }
            for (char c: new char[]{'J','Q','K','A'}){
                cards.add(getFaceCard(suit,c));
            }
        }
        return cards;

    }

    public static void printDeck(List<Card> deck){
        printDeck(deck,"Current Deck",4);
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("--------------");
        if (description != null){
            System.out.println(description);
        }

        int cardsInRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsInRow;
            int lastIndex = startIndex + cardsInRow;
            deck.subList(startIndex,lastIndex).forEach(c -> System.out.print(c+" "));
            System.out.println();
        }
    }
}
