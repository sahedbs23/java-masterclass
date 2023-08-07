package dev.Interface;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(name);
        arrayList.add(Integer.toString(hitPoints));
        arrayList.add(Integer.toString(strength));
        return arrayList;
    }

    @Override
    public void read(List<String> list) {
        if (list.size() == 0){
            return;
        }
        this.name =list.get(0);
        this.hitPoints = Integer.parseInt(list.get(1));
        this.strength = Integer.parseInt(list.get(2));
    }
    @Override
    public String toString() {
//        return String.format("  Monster{name='%s',%nhitPoints='%d', strength='%d'}",name,hitPoints,strength);
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
