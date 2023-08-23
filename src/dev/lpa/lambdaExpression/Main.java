package dev.lpa.lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Alpha",
                "Bravo",
                "Charlie",
                "Delta"
        ));

        for (var myString: list){
            System.out.println(myString);
        }
        System.out.println("-".repeat(10));

        list.forEach(str -> System.out.println(str));

        System.out.println("-".repeat(10));
        String nato = "NATO";

        list.forEach((var myString) -> {
            char str = myString.charAt(0);
            System.out.printf("%s %c mean %s%n", nato,str,myString);
        });
        calculator(Integer::sum, 5, 7);
        calculator((a,b) -> a/b, 60.00, 12.00);
        calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Sahed", "Moral");

        var coords = Arrays.asList(
                new Double[]{21.45,91.45},
                new Double[]{22.45,92.45},
                new Double[]{21.65,93.45}
                );
        BiConsumer<Double,Double> p = (lat, lon) -> System.out.printf("[lat:%.3f, lon:%.3f%n",lat,lon);
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1],p);
        System.out.println("-".repeat(30));
        coords.forEach(s -> processPoint(s[0],s[1],p));
        System.out.println("--------------");
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(System.out::println);
        System.out.println("--------------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(System.out::println);

        System.out.println("---------");
        list.replaceAll(s -> s.charAt(0) + " => "+ s.toUpperCase());
        list.forEach(System.out::println);

        String[] emptyString = new String[10];
        Arrays.fill(emptyString, " ");
        System.out.println(Arrays.toString(emptyString));

        Arrays.setAll(emptyString, i ->  i+1 +"." + switch (i){
            case 0 -> "One";
            case 1 -> "Two";
            case 2 -> "Three";
            default -> " ";
        });
        System.out.println(Arrays.toString(emptyString));

        String[] names = {"Sahed", "Prova", "Promy", "Liza", "Maria"};
        String[] genratedStrs = generateRandomString(15, names,
                () -> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(genratedStrs));
    }

    public static <T> T calculator(Operation<T> function, T val1, T val2){
        var result  = function.operate(val1,val2);
        System.out.println("Result of operation " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1,t2);
    }

    public static String[] generateRandomString(int count, String[] values, Supplier<Integer> t){
        String[] strings = new String[count];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = values[t.get()];
        }
        return strings;
    }
}
