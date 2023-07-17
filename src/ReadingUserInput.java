import java.util.Scanner;

public class ReadingUserInput {
    public static void main(String[] args) {
        System.out.println(getUserInputByScanner());
    }

    public static double getUserInputByScanner(){
        int currentInput = 1;
        double sum  = 0;
        Scanner scanner = new Scanner(System.in);

        boolean isValidInteger = false;
        do {
            try {
                System.out.println("Enter number #" + currentInput);
                String userInput = scanner.nextLine();
                double input =  Double.parseDouble(userInput);
                sum += input;
                currentInput++;
                if (currentInput>5){
                    isValidInteger = true;
                }
            }catch (NumberFormatException badUserInput){
                System.out.println("Invalid number");
            }
        }while (!isValidInteger);

        return sum;

    }

}
