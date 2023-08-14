package dev.GenericsChallenge;


import dev.GenericsChallenge.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T>{

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value){
        ArrayList<T> matches = new ArrayList<>();
        for (T item: items) {
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    public QueryList<T> getMatches(String field, String value){
        QueryList<T> matches = new QueryList<>();
        for (T item: this) {
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
