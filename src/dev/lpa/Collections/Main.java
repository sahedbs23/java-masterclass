package dev.lpa.Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Card[] cardArray = new Card[13];
        Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART,'A');
        Arrays.fill(cardArray,aceOfHeart);
        Card.printDeck(List.of(cardArray), "Ace of Hearts",1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHeart);
        System.out.println(cards);
        System.out.println(cards.size());

        List<Card> archOfHears = Collections.nCopies(13,aceOfHeart);
        Card.printDeck(archOfHears, "Ace of Hearts",1);

        Card kingOfClubs= Card.getFaceCard(Card.Suit.CLUB,'K');
        List<Card> kingsOfClubs = Collections.nCopies(13,kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of club",1);

        Collections.addAll(cards,cardArray);
        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"Card Collections with Ace added",2);

        Collections.copy(cards,kingsOfClubs);
        Card.printDeck(cards,"Card collection with king copied",2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards,"List copy of king",1);


        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffle deck",4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed deck of cards",4);

        var sortAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        deck.sort(sortAlgorithm);
        Card.printDeck(deck, "Sorted with rank, suit",13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed:",13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings,"Kings in deck",1);

        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens, "extracted 10ths from lists",1);

//        Collections.shuffle(deck);
        int indexOfSubLists = Collections.indexOfSubList(deck,tens);
        System.out.println("Index of tens subLists is: "+indexOfSubLists);

        System.out.println("Sub-lists contain in original lists: " + deck.containsAll(tens));

        boolean disjoint1 = Collections.disjoint(deck,tens);
        System.out.println("Deck is disjoint with tens : "+ disjoint1);

        boolean disjoint = Collections.disjoint(kings,archOfHears);
        System.out.println("Deck is disjoint with kings "+ disjoint);

        Card tensOfHeart = Card.getNumericCard(Card.Suit.HEART,10);

        deck.sort(sortAlgorithm);
        int foundIndex = Collections.binarySearch(deck,tensOfHeart,sortAlgorithm);
        System.out.println("FoundIndex : "+foundIndex);
        int indexOf = deck.indexOf(tensOfHeart);
        System.out.println("Index of : "+indexOf);
        System.out.println(deck.get(foundIndex));

        Card tensOfClub = Card.getNumericCard(Card.Suit.CLUB,10);
        Collections.replaceAll(deck,tensOfClub,tensOfHeart);
        Card.printDeck(deck.subList(32,36),"Tens of club replaced with tens of heart",1);

        Collections.replaceAll(deck,tensOfHeart,tensOfClub);
        Card.printDeck(deck.subList(32,36),"Tens of heart replaced with tens of club",1);

        if (Collections.replaceAll(deck,tensOfHeart,tensOfClub)){
            System.out.println("Tens of heart replaced with tend of club");
        }else {
            System.out.println("No replacement happened!");
        }

        System.out.printf("Tens of club found in deck %d times%n",Collections.frequency(deck,tensOfClub));
        System.out.printf("My Best card is %s%n",Collections.max(deck,sortAlgorithm));
        System.out.printf("My Worst card is %s%n",Collections.min(deck,sortAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sort by suit,rank",4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,2);
        System.out.println("UnRotated: "+ deck.subList(0,13));
        System.out.println("Rotated by +2: "+ copied);


        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,-2);
        System.out.println("UnRotated: "+ deck.subList(0,13));
        System.out.println("Rotated -2: "+ copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i < copied.size(); i++) {
            Collections.swap(copied,i,copied.size()-1);
        }
        System.out.println("Manual reverse: " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Reversed by reverse: " + copied);

    }

}
