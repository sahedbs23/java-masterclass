package dev.lpa.lambdaExpressionChalenage;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String pLanguages = "Java PHP JavaScript SQL";

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                var words = s.split(" ");
                for (var w : words) {
                    System.out.println(w);
                }
            }
        };

        Consumer<String> sentence = s -> {
            var words = s.split(" ");
            for (var w : words) {
                System.out.println(w);
            }
        };

        consumer.accept(pLanguages);
        System.out.println("-------");
        sentence.accept(pLanguages);

        Consumer<String> consumerWithForEach = s -> {
            var words = s.split(" ");
            Arrays.asList(words).forEach(System.out::println);
        };

        System.out.println("-------");
        consumerWithForEach.accept(pLanguages);

        Consumer<String> consumerWithConcise = s -> Arrays.asList(s.split(" ")).forEach(System.out::println);
        System.out.println("-------");
        consumerWithConcise.accept(pLanguages);

        System.out.println("-------");
        System.out.println(everySecondString("Hello Dolly, How are you?"));

        System.out.println("-------");



        Function<String, String> everySecondStringWithLambda = s -> {
            StringBuilder returnString = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (i%2 == 1){
                    returnString.append(s.charAt(i));
                }
            }
            return returnString.toString();
        };


        System.out.println(everySecondStringWithLambda.apply("1234567890"));
        System.out.println("-----------");
        System.out.println(everySecondCharacter(everySecondStringWithLambda,"1234567890"));

        Supplier<String> iLoveJava = () -> "I love java";

        System.out.println(iLoveJava.get());


    }

    public static String everySecondString(String source){
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i%2 == 1){
                returnString.append(source.charAt(i));
            }
        }
        return returnString.toString();
    }

    public static <T> T everySecondCharacter(Function<T, T> function, T source){
        return function.apply(source);
    }

}
