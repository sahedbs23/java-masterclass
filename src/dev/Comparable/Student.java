package dev.Comparable;

import java.util.Random;

public class Student implements  Comparable<Student> {
    private static int STUDENT_ID = 1000;
    protected Integer id;
    protected double gpa;
    protected Random random = new Random();
    String name;

    public Student(String name) {
        this.name = name;
        id = STUDENT_ID++;
        gpa = random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %.2f",id,name, gpa);
    }

    @Override
    public int compareTo(Student student) {
        return id.compareTo(student.id);
    }
}
