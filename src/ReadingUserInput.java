public class ReadingUserInput {
    public static void main(String[] args) {
        int currentYear = 2023;
        System.out.println(getUserInputByConsole(currentYear));
    }

    public static int getUserInputByConsole(int currentYear){

        String userNameInput = System.console().readLine("What's you name?");

        System.out.println("Welcome "+ userNameInput);

        String userInputDateOfBirth = System.console().readLine("What is the year you were born?");

        return currentYear - Integer.parseInt(userInputDateOfBirth);
    }
}
