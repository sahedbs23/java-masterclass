package dev.sahedmoral.arrayutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayUtilMethods {
    public static void main(String[] args) {
        List<String> grocaries = List.of(new String[]{"Apple", "Banana"});
        ArrayList<String> gorcariLists = new ArrayList<>(grocaries);
        gorcariLists.add("Orange");
        System.out.println(gorcariLists);

        gorcariLists.add("Mango");
        gorcariLists.add("Mango");
        System.out.println(gorcariLists);

        System.out.println(gorcariLists.get(1));

        if (gorcariLists.contains("Banana")){
            System.out.println("Banana is in the lists");
        }

        System.out.println(gorcariLists.indexOf("Mango"));
        System.out.println(gorcariLists.lastIndexOf("Mango"));

        gorcariLists.remove(0);
        System.out.println(gorcariLists);
        gorcariLists.removeAll(List.of("Mango"));
        System.out.println(gorcariLists);
        gorcariLists.add("Apple");
        System.out.println(gorcariLists);
        gorcariLists.retainAll(Arrays.asList("Banana", "Apple"));
        System.out.println(gorcariLists);

        gorcariLists.sort(Comparator.naturalOrder());
        System.out.println(gorcariLists);

        gorcariLists.sort(Comparator.reverseOrder());
        System.out.println(gorcariLists);

        gorcariLists.clear();
        System.out.println(gorcariLists);

    }
}
