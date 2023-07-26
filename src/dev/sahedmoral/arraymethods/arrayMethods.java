package dev.sahedmoral.arraymethods;

import java.util.Arrays;
import java.util.Random;

public class arrayMethods {
    public static void main(String[] args) {
        int[] newInt = getRandomArrays(10);
        System.out.println(Arrays.toString(newInt));
        Arrays.sort(newInt);
        System.out.println(Arrays.toString(newInt));


        int[] intArrTwo = getRandomArrays(10);
        System.out.println(Arrays.toString(intArrTwo));

        int[] intArrThree = Arrays.copyOf(intArrTwo, intArrTwo.length);
        System.out.println(Arrays.toString(intArrThree));

        Arrays.sort(intArrTwo);
        System.out.println(Arrays.toString(intArrTwo));
        System.out.println(Arrays.toString(intArrThree));

        int[] intArrFour = getRandomArrays(10);
        int[] intArrFive = Arrays.copyOf(intArrFour, 5);
        int[] intArrSix = Arrays.copyOf(intArrFour, 15);

        System.out.println(Arrays.toString(intArrFour));
        System.out.println(Arrays.toString(intArrFive));
        System.out.println(Arrays.toString(intArrSix));

        String[] sArr = {"Sahadat", "sahed", "Lima", "Liza", "Imran", "Maria"};
        System.out.println(Arrays.toString(sArr));
        Arrays.sort(sArr);
        if (Arrays.binarySearch(sArr,"Sahed") != -1){
            System.out.println("Sahed found in the array");
        }

        int[] intArr = {1,2,3,4,5};
        int[] intArr2 = {1,2,3,4,5,0};

        if (Arrays.equals(intArr, intArr2)){
            System.out.println("Arrays are equal");
        }else {
            System.out.println("Arrays are not equal!");
        }

        Random random = new Random();
        int[] intArrays  = new int[10];
        for (int i = 0; i < 10; i++) {
            intArrays[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(intArrays));
        Arrays.sort(intArrays);
        System.out.println(Arrays.toString(intArrays));
        int[] reversShorted = new int[intArrays.length];
        for (int i = 0; i < intArrays.length; i++) {
            reversShorted[intArrays.length-1-i] = intArrays[i];
        }

        System.out.println(Arrays.toString(reversShorted));
    }

    private static int[] getRandomArrays(int len){
        Random random = new Random();

        int[] newInt = new int[len];
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
