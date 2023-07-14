public class SharedDigit {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,13));
        System.out.println(hasSharedDigit(15,55));

    }

    public static boolean hasSharedDigit(int num1, int num2){
        boolean hasSharedDigit = false;

        if ((num1 < 10 || num1 > 99) || (num2 < 10 || num2 > 99)){
            return false;
        }

        while (num1>0){
            int lastDigit = num1 % 10;
            int number2 = num2;
            while (number2>0){
                int lastDigit2 = number2 % 10;
                if (lastDigit == lastDigit2){
                    hasSharedDigit =  true;
                    break;
                }
                number2 /= 10;
            }

            num1 /= 10;
        }

        return hasSharedDigit;
    }

//    public static boolean isNumberInDigit(int number, int number2){
//        boolean isInDigit = false;
//        while (number2>0){
//            int lastDigit = number2 % 10;
//            if (lastDigit == number){
//                isInDigit =  true;
//                break;
//            }
//            number2 /= 10;
//        }
//        return isInDigit;
//    }

//    public static boolean isNotInRange(int number){
//        return number < 10 || number > 99;
//    }
}
