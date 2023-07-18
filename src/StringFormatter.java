public class StringFormatter {

    public static void runMethods() {
        System.out.println("Print a bullet list \n"
                + "\t\u2022 First bullet point\n"
                + "\t\t\u2022 Second bullet point"
        );

        String textBlock = """
                Print a bullet list
                    \u2022 First bullet point
                            \u2022 Second bullet point
                """;
        System.out.println(textBlock);
        int age = 33;
        System.out.printf("Your age is : %d%n", age);
        int bornYear = 2023 - age;
        System.out.printf("Your age is : %d, You born around : %d%n", age, bornYear);

        System.out.printf("Your age is %.2f%n", (float) age);

        for (int i = 1; i <= 1000000000; i = i * 100) {
            System.out.printf("Formatted number is : %9d%n", i);

        }

        String blockText = "You are %d years old%n";
        System.out.format(blockText, age);
        System.out.println("Hello dolly how old are you? I am %d years old".formatted(21));
    }

    public static void stringPropertyMethods(String string) {
        int length = string.length();
        System.out.printf("Length of the string : %d%n", length);
        System.out.printf("First character is : %c%n", string.charAt(0));
        System.out.printf("Last character is : %s%n", string.charAt(length - 1));
    }

    public static void emptyAndBlank(String text){
        if (text.isEmpty()){
            System.out.println("string is empty");
        }

        if (text.isBlank()){
            System.out.println("Text is blank");
        }
    }
}
