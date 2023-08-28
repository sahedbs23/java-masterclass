package dev.lpa.method.referance.chellange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {
    static Random random = new Random();

    record Person(String firstName){
        String last(String name){
            return addLastName(name);
        };
    }
    public static void main(String[] args) {
        String[] names = {"Sahadat","SaHed", "Lima", "Liza", "Imran", "Maria", "Faria", "Prova", "Promy"};

        Person sahed = new Person("Sahed");
        List<UnaryOperator<String>> operatorList = new ArrayList<>(List.of(
               String::toUpperCase,
                Main::addMiddle,
                s-> s + " " + new StringBuilder().append(s, 0, s.indexOf(" ")).reverse(),
                String::new,
                s -> "Howdy " + s,
                String::valueOf,
                sahed::last,
                (new Person("Moral"))::last
        ));

        applyChanges(names,operatorList);

    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions){
        List<String> backedByArray = Arrays.asList(names);
        for (var function: stringFunctions){
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(backedByArray);
        }
    }

    private static String addMiddle(String firstName){
        return firstName +
                " " +
                (char) random.nextInt('A', 'Z') +
                ".";
    }

    private static String addLastName(String name){
        return name + " " + new StringBuilder().append(name, 0, name.indexOf(" ")).reverse();
    }
}
