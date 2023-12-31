public class DigitSum {
    public static void main(String[] args) {
        int number = 19;
        System.out.println("Sum of " + number + " = " +  sumOfTheDigit(number));
    }

    /**
     * find the sum of the integers
     * @param number integer number
     * @return sum of the integer
     * -1 if the number is negative
     * the number if it's single digit
     */
    public static int sumOfTheDigit(int number){
        if (number<0){
            return -1;
        }
        int sum = 0;
        while (number>9){
            // find the right utmost digit
            sum += number % 10;

            // remove the last digit from number
            number /= 10;
        }
        sum += number;
        return sum;
    }


}
