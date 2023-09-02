package dev.lpa.CardChelleange;

public enum FaceCard {
    JACK,
    QUEEN,
    KING,
    ACE;

    public char getFace(){
        return (new char[]{'J', 'Q', 'K','A'}[this.ordinal()]);
    }

    public int getFaceValue(){
        return (new int[]{11,12,13,14}[this.ordinal()]);
    }
}
