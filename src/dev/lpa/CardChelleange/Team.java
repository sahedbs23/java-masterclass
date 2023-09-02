package dev.lpa.CardChelleange;

public enum Team {
    TEAM_A,
    TEAM_B;

    public String getName(){
        return (new String[]{"Team A", "Team B"}[this.ordinal()]);
    }
}
