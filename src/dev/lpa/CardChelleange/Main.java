package dev.lpa.CardChelleange;

public class Main {
    public static void main(String[] args) {
        Joker joker = new Joker();
        joker.distributeCard(3);
//        joker.showBoard();
        joker.play(Suit.HEART);
    }
}
