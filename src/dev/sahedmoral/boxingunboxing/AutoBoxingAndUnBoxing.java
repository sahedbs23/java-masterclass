package dev.sahedmoral.boxingunboxing;

import java.util.ArrayList;

public class AutoBoxingAndUnBoxing {
    public static void main(String[] args) {

        Bank bank = new  Bank("City Bank Limited");

        bank.addCustomer("Sahed");
        bank.addTransaction("Sahed", 500);
        bank.addTransaction("Sahed", -50);
        bank.addTransaction("Sahed", -100);
        bank.printStatement("Sahed");

        System.out.println("-".repeat(20));

        bank.addCustomer("prova");
        bank.addTransaction("prova", 50);
        bank.addTransaction("prova", -5);
        bank.addTransaction("prova", -10);

        bank.printStatement("prova");

//        Integer intBoxingUnnecessary = Integer.valueOf(15);
//        Integer intBoxingDeprecated = new Integer(10);
//
//        int intUnboxingUnnecessary = intBoxingUnnecessary.intValue();
//
//        Integer intBoxing  = 15;
//        int intUnBoxing = intBoxing;
//
//        Double dval = getDoubleObject();
//        System.out.println(dval.getClass().getSimpleName());
//        System.out.println(getDoubleValue(dval));
//
//        Integer[] integersArr = new Integer[5];
//        integersArr[0] = 5;
//        System.out.println(Arrays.toString(integersArr));
//        System.out.println(integersArr[0].getClass().getSimpleName());
//
//        Character[] characters = {'a', 'b', 'c', 'd', 'e'};
//        System.out.println(Arrays.toString(characters));
//        System.out.println(characters.getClass().getSimpleName());
//
//        var lists = getList(1,2,3,4,5);
//        System.out.println(lists);

    }

    private static ArrayList<Integer> getList(Integer... args){
        ArrayList<Integer> list = new ArrayList<>();
        for(int arg : args){
            list.add(arg);
        }
        return list;
    }

    private static Double getDoubleObject(){
        return Double.valueOf(15.0);
    }
    private static double getDoubleValue(Double dval){
        return dval;
    }
}
