package dev.Comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {1,0,5,-50, 50};

        for (Integer num : others){
            int compare = five.compareTo(num);
            System.out.printf("%d %s %d = %d%n", five, compare == 0 ? "=" : (compare > 0 ? ">":"<"), num, compare);
        }

        String apple = "Apple";
        String[] fruits = {"Apple", "Banana", "Grape", "Orange"};

        for (String fruit: fruits){
            int comparison = apple.compareTo(fruit);
            System.out.printf("%s %s %s = %d%n", apple, comparison == 0 ? "=" : (comparison > 0 ? ">":"<"), fruit, comparison);
        }

        Student sahed = new Student("Sahed");

        Student[] students = {new Student("Prova"), new Student("Promy"), new Student("Liza")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        GpaComparator gpaComparator = new GpaComparator();
        Arrays.sort(students, gpaComparator.reversed());
        System.out.println(Arrays.toString(students));

    }
}
