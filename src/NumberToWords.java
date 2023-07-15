public class NumberToWords {
    public static void main(String[] args) {
//System.out.println(getDigitCount(0));
//System.out.println(getDigitCount(reverse(0)));
//                numberToWords(123);
//        numberToWords(1010);
//        numberToWords(1000);
//        numberToWords(-12);
        numberToWords(0);
    }

    public static void numberToWords(int number){
        if (number<0){
            System.out.println("Invalid Value");
        }
        if (number == 0){
            System.out.println("Zero");
            return;
        }
        int reverseNumber  = reverse(number);
        int reversedNumber  = reverseNumber;

        while (reversedNumber>0){
            switch (reversedNumber%10){
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("Zero");
                    break;
            }
            reversedNumber /= 10;
        }
        int numberCount = getDigitCount(number);
        int reverseNumberCount = getDigitCount(reverseNumber);
        int difference = numberCount - reverseNumberCount;
        while (difference>0){
            System.out.println("Zero");
            difference--;
        }
    }
    public static int reverse(int number){
        int reversedNumber = 0;
        int orginalNumber = number < 0 ? -number : number;
        while (orginalNumber>0){
            reversedNumber = (reversedNumber * 10) + (orginalNumber%10);
            orginalNumber /= 10;
        }
        return number<0 ? -reversedNumber:reversedNumber;
    }

    public static int getDigitCount(int number){
        return number<0 ? -1 : String.valueOf(number).length();
    }
}
