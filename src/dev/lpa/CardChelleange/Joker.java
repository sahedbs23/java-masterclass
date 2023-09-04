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

    public void distributeCard(int maxShake) {
        for (int i = 0; i < maxShake; i++) {
            Collections.shuffle(this.cards);
        }
        AtomicInteger startIndex = new AtomicInteger();
        AtomicInteger endEndIndex = new AtomicInteger(8);
        this.players.forEach(player -> {
            player.setCards(this.cards.subList(startIndex.get(), endEndIndex.get()));
            startIndex.set(startIndex.get() + 8);
            endEndIndex.set(endEndIndex.get() + 8);
        });
    }

    /**
     * @param suit term card
     */
    public void play(Suit suit) {
        this.termCard = suit;
        this.scoreTable.put(Team.TEAM_A, 0);
        this.scoreTable.put(Team.TEAM_B, 0);
        boolean keepPlaying = true;
        int loopCount = 0;
        while (keepPlaying) {
            int teamATurnResult = 0;
            int teamBTurnResult = 0;
            System.out.println("Play started by: " + initiator.getName());
//            setInitiator(players.get(0));
            int loopInitiator = this.players.indexOf(initiator);
            for (int i = 0; i < 8; i++) {
                HashMap<Player, Card> playerCards = new HashMap<>();
                ListIterator<Player> listIterator = this.players.listIterator(loopInitiator);
                while (listIterator.hasNext()){
                    var player = listIterator.next();
                    playerCards.put(player,player.throwCard());
                }
                var winnerPlayer = determineWinner(playerCards,this.players.get(loopInitiator));
                if (winnerPlayer.getTeam() == Team.TEAM_A) {
                    teamATurnResult++;
                } else {
                    teamBTurnResult++;
                }
                loopInitiator = this.players.indexOf(winnerPlayer);
            }
            System.out.printf("On Turn %d -> Team A Earned: %d, Team B Earned: %d %n", loopCount, teamATurnResult, teamBTurnResult);
            updatePointTable(findOpositeTeam() == Team.TEAM_A ? teamATurnResult:teamBTurnResult);
            System.out.printf("Turn %d -> Team A Point: %d, Team B Point: %d %n", loopCount, scoreTable.get(Team.TEAM_A), scoreTable.get(Team.TEAM_B));
            loopCount++;
            if (scoreTable.get(Team.TEAM_A) >= 32 || scoreTable.get(Team.TEAM_B) >= 32) {
                keepPlaying = false;
            }
        }
        if (scoreTable.get(Team.TEAM_A) >= 32) {
            System.out.println("The winner is : " + Team.TEAM_A);
        } else {
            System.out.println("The winner is : " + Team.TEAM_B);
        }
    }


    public void showBoard() {
        this.players.forEach(System.out::println);
    }

    public void setTermCard(Suit termCard) {
        this.termCard = termCard;
    }

    public void setInitiator(Player initiator) {
        this.initiator = initiator;
    }

    public void setCallValue(int callValue) {
        if (callValue < 4) {
            return;
        }
        this.callValue = callValue;
    }

    private void addPlayers() {
        int asciiVal = 65;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                this.players.add(new Player((char) asciiVal, Team.TEAM_A));
            } else {
                this.players.add(new Player((char) asciiVal, Team.TEAM_B));
            }
            asciiVal++;
        }
    }

    private void getJokerDeck() {
        for (Suit suit : Suit.values()) {
            for (int rank = 3; rank <= 10; rank++) {
                if (suit == Suit.HEART && rank == 3) {
                    continue;
                }
                this.cards.add(Card.getNumericCard(suit, rank));
            }
            for (FaceCard faceCard : FaceCard.values()) {
                this.cards.add(Card.getFaceCard(suit, faceCard.getFace(), faceCard.getFaceValue()));
            }

        }
        this.cards.add(Card.getFaceCard(Suit.HEART, "JJ", 15));
    }

    private void updatePointTable(int score) {
        var opositeTeam = findOpositeTeam();
        var team = initiator.getTeam();
        var initiatorPreviousScore = scoreTable.get(team);
        var oppositeTeamPreviousScore = scoreTable.get(team);
        if (score >= callValue) {
            if (oppositeTeamPreviousScore > 0) {
                scoreTable.put(opositeTeam, Math.max(0, oppositeTeamPreviousScore - callValue));
            } else {
                scoreTable.put(team, initiatorPreviousScore + callValue);
            }
        } else {
            var result = initiatorPreviousScore - (callValue * 2);
            if (result < 0) {
                scoreTable.put(opositeTeam, -result);
            } else {
                scoreTable.put(team, result);
            }
        }
    }

    public Player determineWinner(HashMap<Player, Card> hashMap, Player initiator) {
        Player winnerPlayer = this.players.get(0);
        int termRank = Integer.MIN_VALUE;
        int rank = 3;

        var initiatorCard = hashMap.get(initiator);

        for (Map.Entry<Player, Card> playerCard : hashMap.entrySet()) {
            if (Objects.equals(playerCard.getValue().face(), "JJ")) {
                winnerPlayer = playerCard.getKey();
                break;
            }

            if ((termRank != Integer.MIN_VALUE && playerCard.getValue().suit() != termCard) ||
                    initiatorCard.suit() != playerCard.getValue().suit()) {
                continue;
            }

            if (playerCard.getValue().suit() == termCard) {
                if (playerCard.getValue().rank() > termRank) {
                    winnerPlayer = playerCard.getKey();
                }
                termRank = Math.max(termRank, playerCard.getValue().rank());
            } else {
                if (playerCard.getValue().rank() > rank) {
                    winnerPlayer = playerCard.getKey();
                }
                rank = Math.max(rank, playerCard.getValue().rank());
            }
        }
        return winnerPlayer;
    }

    private Team findOpositeTeam() {
        if (initiator.getTeam() == Team.TEAM_A) {
            return Team.TEAM_B;
        }
        return Team.TEAM_A;
    }

}
