package dev.sahedmoral.minimum;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum {
    public static void main(String[] args) {
//        int minNumber = findMin(readIntegers(5));
//        System.out.println(minNumber);
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] readIntegers(int len) {
        int[] intArr = new int[len];
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %d the comma delimited integer lists%n", len);
        String intString = scanner.nextLine();
        String[] intStrArr = intString.split(",");
        for (int i = 0; i < intStrArr.length; i++) {
            intArr[i] = Integer.parseInt(intStrArr[i]);
        }
        return intArr;
    }

    public static int findMin(int[] numbers){
        Arrays.sort(numbers);
        return numbers[0];
    }

    public  static void reverseArray(int[] number){
        int i = 0;
        while (i< (number.length/2)){
            int swapNumber = number[number.length-1 - i];
            number[number.length-1 - i] = number[i];
            number[i] = swapNumber;
            i++;
        }
    }
}
