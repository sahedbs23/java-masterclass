package dev.lpa.method.referance;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;


class PlainOldObject{
    private static int user_id = 1;

    private int id;
    public PlainOldObject() {
        this.id = user_id++;
        System.out.println("Creting old object with id = " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Sahed", "Prova", "Rahman", "Akter");

        names.forEach(System.out::println);

        calculator(Integer::sum, 5,10);
        calculator(Double::sum, 5.10,119.34);
        Supplier<PlainOldObject> supplier = PlainOldObject::new;

        PlainOldObject referance1 = supplier.get();
        seedArray(supplier,10);
    }

    private static <T> void calculator(BinaryOperator<T> function, T param1, T param2){
        T result = function.apply(param1,param2);
        System.out.println(result);
    }

    private static PlainOldObject[] seedArray(Supplier<PlainOldObject> supplier, int count){
        PlainOldObject[] referances = new PlainOldObject[count];
        Arrays.setAll(referances, i -> supplier.get());
        return referances;
    }
}
