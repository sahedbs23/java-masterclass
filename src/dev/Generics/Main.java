package dev.Generics;

public class Main {
    public static void main(String[] args) {
        BaseBallTeam phillies1 = new BaseBallTeam("Philadelphia Phillies");
        BaseBallTeam astros1 = new BaseBallTeam("Huston Astros");
        scoreResults(phillies1, 3, astros1,5);

        Affiliation affiliation = new Affiliation("city", "Dhaka, Dhkala", "BD");


        Team<BaseBallPlayer, Affiliation> phillies2 = new Team<>("Philadelphia Phillies", affiliation);
        Team<BaseBallPlayer, Affiliation> astros2 = new Team<>("Huston Astros");
        scoreResults(phillies2, 3, astros2,5);

        phillies2.addTeamMember(new BaseBallPlayer("ABC", "XYZ"));
        phillies2.addTeamMember(new BaseBallPlayer("EDF", "WXY"));

        phillies2.listTeamMembers();

        SportTeam phillies = new SportTeam("Philadelphia Phillies");
        SportTeam astros = new SportTeam("Huston Astros");
        scoreResults(phillies, 3, astros,5);

        var harper = new BaseBallPlayer("B Harper", "Right fielder");
        var marsh = new BaseBallPlayer("B Marsh", "Right fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);

        phillies.listTeamMembers();

        Team<FootBallPlayer, String> abohani = new Team<>("Abohani", "City Barisal, BD");
        Team<FootBallPlayer, String> mohamadan = new Team<>("Mohamodan");
        scoreResults(abohani,2, mohamadan,3);

        var dorjoy = new FootBallPlayer("Naimur Rahman Dorjoy", "Middle order Batsman");
        var kapali = new FootBallPlayer("Alok Kapali", "Middle order Batsman");
        abohani.addTeamMember(dorjoy);
        abohani.addTeamMember(kapali);
        abohani.listTeamMembers();

        Team<CricketPlayer,Integer> cricketTeam  = new Team<>("Dhaka Gladiators");
        cricketTeam.addTeamMember(new CricketPlayer("Mashrafi Bin Matoza", "Baller"));
        cricketTeam.listTeamMembers();


    }

    public static void scoreResults(BaseBallTeam team1, int t1_score,
                                    BaseBallTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);

    }

    public static void scoreResults(SportTeam team1, int t1_score,
                                    SportTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }


    public static void scoreResults(Team team1, int t1_score,
                                    Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
