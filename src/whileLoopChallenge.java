public class whileLoopChallenge {

    public static void main(String[] args) {
        byte min = 4;
        byte max = 20;
        int even=0,odd = 0;

        while (min<=max){
            if (isEventNumber(min)){
                even++;
                System.out.println(min+" is a even number!");
            }else {
                odd++;
            }
            min++;
        }

        System.out.println(odd);
        System.out.println(even);

    }

    public static boolean isEventNumber(int number){
        return number % 2 == 0;
    }
}
