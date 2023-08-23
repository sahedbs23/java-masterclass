package dev.lpa.lmabdaExpresionPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Main.Person("Sahed", "Moral"),
                new Person("Rejuana", "Rahman"),
                new Person("Promy", "Rahman"),
                new Person("Sahadat", "Hossain"),
                new Person("Imran", "Hossain"),
                new Person("Abdur", "Rahman"),
                new Person("Amina", "Azrin")
        ));

        people.sort(Comparator.comparing(o -> o.lastName));
        System.out.println(people);

        interface EnhanceComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }


        var enhancePersonComparator = new EnhanceComparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                int comparison = o1.lastName.compareTo(o2.lastName);
                if (comparison == 0){
                    return secondLevel(o1,o2);
                }
                return comparison;
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        people.sort(enhancePersonComparator);
        System.out.println(people);
    }
}
