package dev.lpa;

import dev.lpa.Model.LpaStudent;
import dev.lpa.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int maxNumberOfStudents = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < maxNumberOfStudents; i++) {
            students.add(new Student());
        }

        students.add(new LpaStudent());
        printStudent(students);

        var queryLists = new QueryList<>(students);
        var matches= queryLists.getMatches("course", "java");
        printStudent(matches);



        List<LpaStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < maxNumberOfStudents; i++) {
            lpaStudents.add(new LpaStudent());
        }
        PrintMoreStudents(lpaStudents);

        List<String> familyMembers = new ArrayList<>(List.of("Sahed", "Rejuana", "Promy"));
        printMore(familyMembers);

        List<Integer> monthlyIncome = new ArrayList<>(List.of(100000, 115000,25000));
        printMore(monthlyIncome);

        var student2021 = QueryList.getMatches(students,"yearStarted", "2021");
        printStudent(student2021);

        var student2020 = QueryList.<Student>getMatches(new ArrayList<>(), "yearStarted", "2020");
        printStudent(student2020);



    }

    private static void printMore(List<?> lists){
        for (var list: lists){

            if (list instanceof  String l){
                System.out.println("String : "+ l.toUpperCase() );
            } else if (list instanceof Integer I) {
                System.out.println("Integer : "+ I.doubleValue() );
            }
        }
    }

    private static void PrintMoreStudents(List<? extends Student> students){
        for (var student: students){
            System.out.println(student);
        }
        System.out.println("");
    }

    private static <T> void printStudent(List<T> students){
        for (var student: students){
            System.out.println(student);
        }
        System.out.println("");
    }
}
