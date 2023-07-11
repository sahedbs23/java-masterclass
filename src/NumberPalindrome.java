// Coding exercise 16
public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-222));
    }

    public static boolean isPalindrome(int number){
        number = number < 0 ? -number : number;
        int reversNumber = 0;
        int originalNumber=number;
        while (number>0){
            int lastDigit = number % 10;
            reversNumber =  (reversNumber * 10) + lastDigit;
            number /= 10;
        }
        return originalNumber == reversNumber;
    }
}
