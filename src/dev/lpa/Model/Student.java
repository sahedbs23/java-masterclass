package dev.lpa.Model;

import dev.lpa.QueryItem;

import java.util.Random;

public class Student implements QueryItem {
    private String name;
    private String course;
    private int yearStarted;
    protected Random random = new Random();
    private static String[] students = {"Sahadat","Sahed", "Rejuana", "Promy", "Lima", "Liza", "Imran", "Maria"};
    private static String[] courses = {"Java", "Python", "C++"};

    public Student() {
        int lastNameIndex = random.nextInt(65,91);
        name = students[random.nextInt(0,students.length)] +" "+ (char) lastNameIndex;
        course = courses[random.nextInt(0,courses.length)];
        yearStarted = random.nextInt(2019, 2023);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %-15d".formatted(name, course,yearStarted);
    }

    @Override
    public boolean matchFieldValue(String field, String value) {
        String fName = field.toUpperCase();
        return switch (fName){
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }
}
