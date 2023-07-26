package dev.sahedmoral.twodiemtion;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] twoDimIntArr = new int[4][4];

        for (int i = 0; i < twoDimIntArr.length; i++) {
            var innerArr = twoDimIntArr[i];
//            System.out.println(Arrays.toString(innerArr));
            for (int j = 0; j < innerArr.length; j++) {
                twoDimIntArr[i][j] = (i * 10) + j+1;
            }
        }
        System.out.println(Arrays.deepToString(twoDimIntArr));
        System.out.println("-".repeat(20));

        for(var outerArr : twoDimIntArr){
            for(var innerArr : outerArr){
                System.out.print(innerArr + " ");
            }
            System.out.println();
        }
    }


}
