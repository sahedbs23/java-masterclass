package dev.lpa.CardChelleange;

import java.util.*;

public class Player{
    private List<Card> cards;
    private final List<Card> playedCards;
    private String name;
    private final Team team;
    public Player(String name,Team team) {
        this.name = name;
        this.team = team;
        this.cards = new ArrayList<>(8);
        this.playedCards = new ArrayList<>(8);
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
        return "%s of %s : %s".formatted(name,team.getName(),"");
    }

    public String getName() {
        return "%s : %s".formatted(team.getName(),name);
    }
}
