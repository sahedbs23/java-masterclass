package dev.sahedmoral.enums;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DaysOfTheWeek weekDay = DaysOfTheWeek.FRIDAY;
        System.out.printf("Value = %s, index value = %d%n",weekDay.name(), weekDay.ordinal() );

        int randomInt = new Random().nextInt(7);
        var daysOfTheWeek = DaysOfTheWeek.values();
        System.out.println(daysOfTheWeek[randomInt]);
        printMessage(DaysOfTheWeek.FRIDAY);
        printMessage(DaysOfTheWeek.MONDAY);
    }

    private static void printMessage(DaysOfTheWeek daysOfTheWeek){
        System.out.println(daysOfTheWeek);
    }


}
