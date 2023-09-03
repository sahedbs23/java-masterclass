package dev.lpa.CardChelleange;

import java.util.*;

public class Player{
    private Scanner scanner;
    private List<Card> cards;
    private List<Card> playedCards;
    private char name;
    private Team team;
    public Player(char name,Team team) {
        this.name = name;
        this.team = team;
        this.cards = new ArrayList<>(8);
        this.playedCards = new ArrayList<>(8);
        this.scanner = new Scanner(System.in);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards.subList(0,8);
        this.cards.sort(Comparator.comparingInt(Card::rank)) ;
    }

    public Card throwCard(){
        List<Card> tempCards = new ArrayList<>(this.cards);
        var res = tempCards.removeAll(playedCards);
        int userInput = new Random().nextInt(0,tempCards.size()-1);
        playedCards.add(cards.get(userInput));
        return this.cards.get(userInput);
    }

    public Team getTeam(){
        return team;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card: this.cards) {
            stringBuilder.append(card.toString());
            stringBuilder.append(" ");
        }
        return "%c of %s : %s".formatted(name,team.getName(),"");
    }

    public String getName() {
        return "%s : %c".formatted(team.getName(),name);
    }
}
