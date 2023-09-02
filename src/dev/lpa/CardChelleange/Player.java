package dev.lpa.CardChelleange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player{
    private List<Card> cards;
    private char name;
    private Team team;
    public Player(char name,Team team) {
        this.name = name;
        this.team = team;
        this.cards = new ArrayList<>(8);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards.subList(0,7);
        this.cards.sort(Comparator.comparingInt(Card::rank)) ;
    }

    public Card throwCard(){
        return this.cards.get(this.cards.size()-1);
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
        return "%c of %s : %s".formatted(name,team.getName(),stringBuilder.toString());
    }

    public String getName() {
        return "%s : %c".formatted(team.getName(),name);
    }
}
