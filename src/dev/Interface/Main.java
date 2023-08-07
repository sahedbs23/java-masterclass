package dev.Interface;

public class Main {
    public static void main(String[] args) {
        Monster monster = new Monster("Werewolf",20,40);
        System.out.println(monster);

        Player player = new Player("Sahed",5,10);
        System.out.println(player);
    }
}
