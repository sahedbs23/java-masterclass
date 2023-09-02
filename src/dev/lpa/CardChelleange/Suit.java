package dev.lpa.CardChelleange;

public enum Suit {
    CLUB,DIAMOND,HEART,SPREAD;

    public char getImage(){
        return (new char[]{9827,9830,9829,9824})[this.ordinal()];
    }
}
