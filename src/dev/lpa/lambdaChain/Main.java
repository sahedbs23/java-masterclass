package dev.lpa.lambdaChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String name = "Sahed";

        Function<String,String> uCase = String::toUpperCase;

        Function<String,String> lName = s -> s + " " + "Moral";

        Function<String,String> addLNameAndMakeUpper = lName.andThen(uCase);

        System.out.println(addLNameAndMakeUpper.apply(name));

        Function<String,String> compose = uCase.compose(lName);

        System.out.println(compose.apply(name));

        Function<String,String[]> f0 = lName
                .andThen(uCase)
                .andThen( s -> s.split(" "));

        System.out.println(Arrays.toString(f0.apply(name)));


        Function<String,String> f1 = lName
                .andThen(uCase)
                .andThen( s -> s.split(" "))
                .andThen(s-> s[1] + ", "+s[0]);
        System.out.println(f1.apply(name));

        Function<String,Integer> f2 = lName
                .andThen(uCase)
                .andThen( s -> s.split(" "))
                .andThen(s-> s[1] + ", "+s[0])
                .andThen(String::length);

        System.out.println(f2.apply(name));

        String[] names = {"Sahed", "Moral", "sawon"};

        Predicate<String> p1 = s -> s.equals("SAHED");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Sahed");
        Predicate<String> p3 = s -> s.startsWith("S");
        Predicate<String> p4 = s -> s.endsWith("A");

        Predicate<String> combined1 = p1.or(p2);
        Predicate<String> combined2 = p3.and(p4).negate();

        System.out.println("Combined1 with name : " + combined1.test(name));
        System.out.println("Combined2 with name : " + combined2.test(name));


        record Person(String firstName, String lastName){}

        List<Person> collections = new ArrayList<>(List.of(
                new Person("Peter", "Pen"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minni", "Mouse"),
                new Person("Micky", "Mouse")
        ));

        System.out.println("-".repeat(30));
        collections.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        collections.forEach(System.out::println);


        System.out.println("-".repeat(30));
        collections.sort(Comparator.comparing(Person::lastName));
        collections.forEach(System.out::println);


        System.out.println("-".repeat(30));
        collections.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName));
        collections.forEach(System.out::println);

        System.out.println("-".repeat(30));
        collections.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                .reversed()
        );
        collections.forEach(System.out::println);


    }
}
