package dev.GenericsChallenge;

import dev.GenericsChallenge.Model.LpaStudent;

import java.util.Comparator;

public class LpaStudentComparator implements Comparator<LpaStudent> {
    @Override
    public int compare(LpaStudent o1, LpaStudent o2) {
        return (int) (o1.getPercentageCompleted() - o2.getPercentageCompleted());
    }
}
