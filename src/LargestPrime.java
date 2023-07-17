public class LargestPrime {
    public static void main(String[] args) {
        getLargestPrime(16);
    }

    public static void getLargestPrime(int number){
        for(int i = 2; i< number; i++) {
            while(number%i == 0) {
                if (number/i <2){
                    break;
                }
                number = number/i;
            }
        }
            System.out.println(number);
    }
}
