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
        this.callValue = 5;
        this.initiator = this.players.get(0);
        getJokerDeck();
    }

    public void distributeCard(int maxShake){
        for (int i = 0; i < maxShake; i++) {
            Collections.shuffle(this.cards);
        }
        AtomicInteger startIndex= new AtomicInteger();
        AtomicInteger endEndIndex= new AtomicInteger(8);
        this.players.forEach(player -> {
            player.setCards(this.cards.subList(startIndex.get(), endEndIndex.get()));
            startIndex.set(startIndex.get() + 8);
            endEndIndex.set(endEndIndex.get() + 8);
        });
    }

    /**
     *
     * @param suit term card
     */
    public void play(Suit suit){
        this.termCard = suit;
        this.scoreTable.put(Team.TEAM_A,0);
        this.scoreTable.put(Team.TEAM_B,0);
        boolean keepPlaying = true;
        int loopCount = 0;
        while (keepPlaying){
            int teamATurnResult = 0;
            int teamBTurnResult = 0;
            System.out.println("Play started by: " + initiator.getName());
            for (int i = 0; i < 8; i++) {
                HashMap<Player,Card> playerCards = new HashMap<>();
                this.players.forEach(player -> playerCards.put(player,player.throwCard()));
                var winnerPlayer = determineWinner(playerCards);
                if ( winnerPlayer.getTeam() == Team.TEAM_A){
                    teamATurnResult++;
                }else {
                    teamBTurnResult++;
                }
                setInitiator(winnerPlayer);
            }
            System.out.printf("On Turn %d -> Team A Earned: %d, Team B Earned: %d %n", loopCount,teamATurnResult,teamBTurnResult);
            updatePointTable(teamATurnResult, teamBTurnResult);
            System.out.printf("Turn %d -> Team A Point: %d, Team B Point: %d %n", loopCount,scoreTable.get(Team.TEAM_A),scoreTable.get(Team.TEAM_B));
            loopCount++;
            if (scoreTable.get(Team.TEAM_A) >=32 || scoreTable.get(Team.TEAM_B) >= 32){
                keepPlaying=false;
            }
        }
        if (scoreTable.get(Team.TEAM_A) >= 32){
            System.out.println("The winner is : "+ Team.TEAM_A);
        }else {
            System.out.println("The winner is : "+ Team.TEAM_B);
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
    private void updatePointTable(int teamATurnResult, int teamBTurnResult){
      if (initiator.getTeam() == Team.TEAM_A){
          if (teamATurnResult >= callValue){
              var teamBScore = scoreTable.get(Team.TEAM_B);
              if (teamBScore > 0){
                  scoreTable.put(Team.TEAM_B,Math.max(0,teamBScore-callValue));
                  scoreTable.put(Team.TEAM_A, Math.max(0,teamBScore));
              }else {
                  scoreTable.put(initiator.getTeam(),this.scoreTable.get(initiator.getTeam())+callValue);
              }
          }else {
              int latestScore = this.scoreTable.get(initiator.getTeam()) - (callValue*2);
              this.scoreTable.put(initiator.getTeam(),Math.max(0, latestScore));
              this.scoreTable.put(Team.TEAM_B, -latestScore);
          }
      }else {
          if (teamBTurnResult >= callValue){
              var teamAScore = scoreTable.get(Team.TEAM_A);
              if (teamAScore > 0){
                  scoreTable.put(Team.TEAM_A,0);
                  scoreTable.put(Team.TEAM_B, -teamAScore);
              }else {
                  scoreTable.put(initiator.getTeam(),this.scoreTable.get(initiator.getTeam())+callValue);
              }
          }else {
              int latestScore = this.scoreTable.get(initiator.getTeam()) - (callValue*2);
              this.scoreTable.put(initiator.getTeam(),Math.max(0, latestScore));
              this.scoreTable.put(Team.TEAM_A, -latestScore);
          }
      }

    }

    public Player determineWinner(HashMap<Player, Card> hashMap) {
        Player winnerPlayer = this.players.get(0);
        int termRank = Integer.MIN_VALUE;
        int rank = 3;

        var initiatorCard = hashMap.get(initiator);

       for (Map.Entry<Player,Card> playerCard : hashMap.entrySet()){
           if (Objects.equals(playerCard.getValue().face(), "JJ")){
               winnerPlayer = playerCard.getKey();
               break;
           }

           if ((termRank != Integer.MIN_VALUE && playerCard.getValue().suit() != termCard) ||
                   initiatorCard.suit() != playerCard.getValue().suit()){
               continue;
           }

           if (playerCard.getValue().suit() == termCard){
               if(playerCard.getValue().rank() > termRank){
                  winnerPlayer = playerCard.getKey();
               }
               termRank = Math.max(termRank,playerCard.getValue().rank());
           }else {
               if(playerCard.getValue().rank() > rank){
                   winnerPlayer = playerCard.getKey();
               }
               rank = Math.max(rank,playerCard.getValue().rank());
           }
       }
       return winnerPlayer;
    }

}
