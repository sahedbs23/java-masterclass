import java.util.Scanner;

public class MinMaxChallenge {

    public static void main(String[] args) {
//        minMaxInput();
        System.out.println((long) Math.round((float) 11/3));
    }

    public static void minMaxInput(){
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = false;
        double min = Double.MAX_VALUE, max=Double.MIN_VALUE;
        do {
            String userInput = scanner.nextLine();
            try {
                double number =  Double.parseDouble(userInput);
                min = Math.min(min, number);
                max = Math.max(max, number);
            }catch (NumberFormatException badInput){
                continueLoop = true;
            }
        }while (!continueLoop);

        System.out.println(min);
        System.out.println(max);
    }
}
