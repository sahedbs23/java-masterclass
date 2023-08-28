package dev.lpa.CollectionOviewview;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> list = new HashSet<>();

        String[] users = {"Sahed", "Sahadat","Afroza", "Prova", "Sajid", "Amena"};

        list.addAll(Arrays.asList(users));
        list.forEach(System.out::println);
        System.out.println("-".repeat(10));

        list.addAll(List.of("Molla", "Morol", "Mondol"));
        list.forEach(System.out::println);
        System.out.println("-".repeat(10));

        System.out.println("List container Molla? "+list.contains("Molla"));

        list.removeIf(s -> s.charAt(0) == 'M');
        list.forEach(System.out::println);

    }
}
