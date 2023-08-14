package dev.GenericsChallenge;


import dev.GenericsChallenge.Model.LpaStudent;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryList<LpaStudent> queryLists = new QueryList<>();
        for (int i = 0; i < 15; i++) {
            queryLists.add( new LpaStudent());
        }
        queryLists.sort(Comparator.naturalOrder());
        printLists(queryLists);

        System.out.println("-".repeat(30));

        var matcher = queryLists.getMatches("percentageCompleted", "50")
                .getMatches("course","java");
        printLists(matcher);

        System.out.println("-".repeat(30));

        matcher.sort(new LpaStudentComparator());
        printLists(matcher);
        System.out.println("-".repeat(30));
        matcher.sort(null);
        printLists(matcher);

    }

    private static void printLists(List<?> students){
        for (var student : students){
            System.out.println(student);
        }
    }
}
