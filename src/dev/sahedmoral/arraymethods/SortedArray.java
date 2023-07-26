package dev.sahedmoral.arraymethods;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortIntegers(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(getIntegers(5)));
    }


    public static int[] getIntegers(int len){
        Scanner scanner = new Scanner(System.in);
        int[] intArr = new int[len];
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    public static void printArray(int[] intArr){
        for (int i=0;i<intArr.length; i++ ){
            System.out.printf("Element %d contents %d", i, intArr[i]);
        }
    }

    public static int[] sortIntegers(int[] intArr){
        int i = 0;
        while(i<intArr.length-1){
            if (intArr[i] < intArr[i+1]) {
                int j = i+1;
                while (j>0){
                    if (intArr[j] > intArr[j-1]){
                    int swap = intArr[j];
                    intArr[j] = intArr[j-1];
                    intArr[j-1] = swap;
                    }
                    j--;

                }
            }else {
                i++;
            }
        }

        return intArr;
    }
}

