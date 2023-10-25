package miu.isCentered;

public class IsCentered {
    public static void main(String[] args){
        System.out.println(isCentered(new int[] {1,2,3,4,5} ));
        System.out.println(isCentered(new int[]{3,2,1,4,5} ));
        System.out.println(isCentered(new int[]{3,2,1,4,1} ));
        System.out.println(isCentered(new int[]{1,2,3,4} ));
        System.out.println(isCentered(new int[]{} ));
        System.out.println(isCentered(new int[]{10} ));
    }

    public static int isCentered(int[] numbers){
        if( numbers.length % 2 == 0){
            return 0;
        }
        int i = 0;
        int j = numbers.length - 1;
        int mid =  (i + j) / 2 ;
        while (i<mid && mid < j){
            if (numbers[i] <= numbers[mid] || numbers[j] <= numbers[mid]){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
}
