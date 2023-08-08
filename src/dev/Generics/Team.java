package dev.Generics;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player, S> {
    private final String teamName;
    private final List<T> teamMembers = new ArrayList<>();
    private int totalWins=0;
    private int totalLoses=0;
    private int totalTies=0;
    private S affiliation;

    public Team(String name) {
        this.teamName = name;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t){
        if (!teamMembers.contains(t)){
            teamMembers.add(t);
        }
    }

    public void listTeamMembers(){
        System.out.print(teamName + " Roster:");
        System.out.println(affiliation != null ? affiliation : "");
        for (T t: teamMembers){
            System.out.println(t.name());
        }
    }

    public int ranking(){
        return (totalLoses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if (ourScore>theirScore){
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        }else {
            totalLoses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked "+ranking()+" )";
    }
}
