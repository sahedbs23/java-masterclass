package dev.sahedmoral;

public class Main {
    public static void main(String[] args) {
        Item item = new Item("First Item from class Dev.sahedmoral");
        System.out.println(item);
        System.out.println(isCentered(new int[]{1,2,3,4,5}));
    }

    public static boolean isCentered(int[] numbers){
        if (numbers.length % 2 ==0){
            return false;
        }
        int mid = numbers.length / 2;

        System.out.println(mid);
        return true;
    }
}
