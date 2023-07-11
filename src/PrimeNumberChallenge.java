public class PrimeNumberChallenge {

    public static void main(String[] args) {

        byte primeNumberCounter = 0;

        for (int i = 10; primeNumberCounter<3 && i <= 1000; i++) {
            if (isPrime(i)){
                System.out.println(i);
                primeNumberCounter++;
            }
        }

    }

    public static boolean isPrime(int wholeNumber) {

        if (wholeNumber <= 2) {
            return (wholeNumber == 2);
        }

        for (int divisor = 2; divisor <= wholeNumber / 2; divisor++) {
            if (wholeNumber % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
