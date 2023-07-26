package dev.sahedmoral.array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Integer array with length of 10");
        int[] myIntArr = new int[10];
        myIntArr[0] = 1;
        myIntArr[5] = 6;
        myIntArr[9] = 10;

        System.out.printf("Length of my integer array is %d%n", myIntArr.length);
        for (int i = 0; i < myIntArr.length; i++) {
            System.out.printf("myIntArr[%d] : %d%n", i,myIntArr[i]);
        }
        System.out.printf("%s%n", "...".repeat(10));

        System.out.println("Initializing String array with length of 10");
        String[] myStrArr = new String[10];
        myStrArr[0] = "One";
        myStrArr[1] = "Two";
        myStrArr[2] = "Three";
        myStrArr[3] = "Four";
        System.out.printf("Length of my string array is %d%n", myStrArr.length);
        for (int j = 0; j < myStrArr.length; j++) {
            System.out.printf("myIntArr[%d] : %s%n", j,myStrArr[j]);
        }

        System.out.printf("%s%n", "...".repeat(10));

        System.out.println("Initializing array without specifying the length");

        String[] itemLists = {"Item one", "Item two", "Item three", "Item four", "Item Five"};

        System.out.printf("Length of Item lists %d%n", itemLists.length);
        for (int j = 0; j < itemLists.length; j++) {
            System.out.printf("myIntArr[%d] : %s%n", j,itemLists[j]);
        }

        double[] doubleArr = {1.0,2.0,3.0,4.0,5.0};
        for (double number : doubleArr){
            System.out.println(number);
        }

        int[] newArr = new int[5];

        if (newArr instanceof int[]){
            System.out.println("New array is a integer array");
        }

        Object[] object = new Object[3];

        object[0]  = "Hello";
        object[1]  = new StringBuilder("World");

        System.out.println(Arrays.toString(object));
    }
}
