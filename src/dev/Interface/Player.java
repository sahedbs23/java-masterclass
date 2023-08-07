package dev.Interface;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    @Override
    public List<String> write() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(name);
        arrayList.add(Integer.toString(hitPoints));
        arrayList.add(Integer.toString(strength));
        arrayList.add(weapon);
        return arrayList;
    }

    @Override
    public void read(List<String> list) {
        if (list ==null || list.size() == 0){
            return;
        }
        this.name =list.get(0);
        this.hitPoints = Integer.parseInt(list.get(1));
        this.strength = Integer.parseInt(list.get(2));
        this.weapon =list.get(3);

    }

    @Override
    public String toString() {
//        return String.format("  Player{name='%s',%nhitPoints='%d', strength='%d'%nweapon='%s'%n}",name,hitPoints,strength,weapon);
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
