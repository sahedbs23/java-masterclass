package dev.lpa.tasks;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var tasks= TaskData.getData("bob");
        tasks.forEach(System.out::println);
    }
}
