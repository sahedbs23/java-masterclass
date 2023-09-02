package dev.lpa.CardChelleange;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Joker {
    private Suit termCard;
    private Player initiator;
    private List<Player> players;
    private List<Card> cards;

    private List<List<Card>> turnCards;

    private HashMap<Team, Integer> scoreTable;

    private int callValue;

    public Joker() {
        this.players = new ArrayList<>(6);
        addPlayers();
        this.cards = new ArrayList<>();
        this.scoreTable = new HashMap<>(1);
        this.turnCards = new ArrayList<>();
        this.callValue = 4;
        this.initiator = this.players.get(0);
        getJokerDeck();
    }

    public void distributeCard(int maxShake){
        for (int i = 0; i < maxShake; i++) {
            Collections.shuffle(this.cards);
        }
        AtomicInteger startIndex= new AtomicInteger();
        AtomicInteger endEndIndex= new AtomicInteger(7);
        this.players.forEach(player -> {
            player.setCards(this.cards.subList(startIndex.get(), endEndIndex.get()));
            startIndex.set(startIndex.get() + 8);
            endEndIndex.set(endEndIndex.get() + 8);
        });
    }

    /**
     *
     * @param suit Team card
     */
    public void play(Suit suit){
        this.termCard = suit;
        this.scoreTable.put(Team.TEAM_A,0);
        this.scoreTable.put(Team.TEAM_B,0);
        boolean keepPlaying = true;
        int index = 0;
        HashMap<Integer,HashMap<Player,Card>> hashMap = new HashMap<>();
        while (keepPlaying){
            for (int i = 0; i < 8; i++) {
                HashMap<Player,Card> playerCards = new HashMap<>();
                this.players.forEach(player -> {
                    playerCards.put(player,player.throwCard());
                });
                hashMap.put(i,playerCards);
//                System.out.println(i);
//                System.out.println(playerCards);
                determineWinner(playerCards);
            }
            keepPlaying=false;

//            this.updatePointTable(playerCards);
//            index++;
//            if (index==6){
//                keepPlaying=false;
//            }
//            System.out.println(this.scoreTable.get(Team.TEAM_A));
//            System.out.println(this.scoreTable.get(Team.TEAM_B));
        }
    }



    public void showBoard(){
        this.players.forEach(System.out::println);
    }

    public void setTermCard(Suit termCard) {
        this.termCard = termCard;
    }

    public void setInitiator(Player initiator) {
        this.initiator = initiator;
    }

    public void setCallValue(int callValue) {
        if (callValue<4){
            return;
        }
        this.callValue = callValue;
    }

    private void addPlayers(){
        int asciiVal = 65;
        for (int i = 0; i < 6; i++) {
            if (i%2==0){
                this.players.add(new Player( (char) asciiVal,Team.TEAM_A));
            }else {
                this.players.add(new Player((char) asciiVal,Team.TEAM_B));
            }
            asciiVal++;
        }
    }

    private void getJokerDeck(){
        for (Suit suit : Suit.values()){
            for (int rank = 3; rank <= 10; rank++) {
                if (suit == Suit.HEART && rank==3){
                    continue;
                }
                this.cards.add(Card.getNumericCard(suit,rank));
            }
            for (FaceCard faceCard: FaceCard.values()) {
                this.cards.add(Card.getFaceCard(suit,faceCard.getFace(),faceCard.getFaceValue()));
            }

        }
        this.cards.add(Card.getFaceCard(Suit.HEART,"JJ",15));
    }
    private void updatePointTable(HashMap<Player,Card> playerCardHashMap){
        AtomicInteger teamAScore = new AtomicInteger();
        AtomicInteger teamBScore = new AtomicInteger();
        playerCardHashMap.forEach((k,v) ->{
            if (k.getTeam() == Team.TEAM_A){
                teamAScore.set(Integer.max(teamAScore.get(), v.rank()));
            }else {
                teamBScore.set(Integer.max(teamBScore.get(), v.rank()));
            }
        });

        int teamACurrentScore= this.scoreTable.get(Team.TEAM_A);
        int teamBCurrentScore= this.scoreTable.get(Team.TEAM_A);

        if (this.initiator.getTeam() == Team.TEAM_A){
            this.updateScore(teamAScore, Team.TEAM_A, Team.TEAM_B,teamACurrentScore,teamBCurrentScore);
        }else {
            this.updateScore(teamBScore, Team.TEAM_B, Team.TEAM_A,teamBCurrentScore, teamACurrentScore);
        }

    }

    private void updateScore(AtomicInteger teamAScore, Team teamA, Team teamB,
                             int teamACurrentScore, int teamBCurrentScore){
        if (teamAScore.get() >= callValue){
            this.scoreTable.put(teamA, teamACurrentScore + teamAScore.get());
        }else {
            teamACurrentScore = teamACurrentScore - (callValue*2);
            if (teamACurrentScore>=0){
                this.scoreTable.put(teamA,teamACurrentScore);
            }else {
                this.scoreTable.put(teamB,teamBCurrentScore+teamACurrentScore);
            }
        }
    }

    private Team determineWinner(HashMap<Player, Card> hashMap) {
        Team winnerTeam = Team.TEAM_A;
        int termRank = 3;
        int rank = 3;

       for (Map.Entry<Player,Card> playerCard : hashMap.entrySet()){
           if (Objects.equals(playerCard.getValue().face(), "JJ")){
               winnerTeam = playerCard.getKey().getTeam();
               break;
           }

           if (playerCard.getValue().suit() == this.termCard){
               if(termRank < playerCard.getValue().rank()){
                   winnerTeam = playerCard.getKey().getTeam();
               }
               termRank = Math.max(termRank,playerCard.getValue().rank());
           }else {
               if (playerCard.getKey().getTeam() != winnerTeam) {
                   if (playerCard.getValue().rank() > rank){
                       winnerTeam = playerCard.getKey().getTeam();
                   }
               }
               rank = Math.max(rank,playerCard.getValue().rank());
           }

       }
       return winnerTeam;
    }

}
