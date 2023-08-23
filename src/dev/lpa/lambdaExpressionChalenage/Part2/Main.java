package dev.lpa.lambdaExpressionChalenage.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static Random random = new Random();
    public static void main(String[] args) {
        String[] familyMembers = {"SaHed", "Sahadat", "Lima", "Liza", "Imran", "Maria", "Prova", "Promy", "BoB", "Anna"};
        System.out.println(Arrays.toString(familyMembers));
        System.out.println("-".repeat(10));

        Arrays.setAll(familyMembers, i -> familyMembers[i].toUpperCase());
        System.out.println(Arrays.toString(familyMembers));
        System.out.println("-".repeat(10));

        List<String> backedByArray = Arrays.asList(familyMembers);
        System.out.println("-------");
        System.out.println(backedByArray);

        backedByArray.replaceAll(s -> s += " " + getRandomCharacter('A', 'D') + ".");
        System.out.println("-------");
        System.out.println(backedByArray);

        backedByArray.replaceAll(s -> s += " " + getReverseName(s.split(" ")[0]));
        System.out.println("-------");
        System.out.println(backedByArray);

        List<String> newList = new ArrayList<>(List.of(familyMembers));

        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)));
        System.out.println("-------");
        System.out.println(newList);
//        familyMembers.replaceAll(s -> s + " " + new StringBuilder().append(s).reverse());
//        familyMembers.forEach(System.out::println);
//        System.out.println("-".repeat(10));
//        familyMembers.replaceAll(String::toUpperCase);
//        familyMembers.forEach(System.out::println);
//
//        List<String> fullanames = new ArrayList<>(familyMembers);
//        fullanames.forEach(System.out::println);
//        fullanames.removeIf(s -> {
//            var arr = s.split(" ");
//            return Objects.equals(arr[0], arr[1]);
//        });
//        System.out.println("-----------");
//        fullanames.forEach(System.out::println);

    }

    public static char getRandomCharacter(char c1, char c2){
        return (char) random.nextInt(c1, c2+1);
    }

    public static String getReverseName(String name){
        return new StringBuilder().append(name).reverse().toString();
    }
}
