public class FlourPacker {
    public static void main(String[] args) {
        System.out.println(canPack (1, 0, 4));
        System.out.println(canPack (1, 0, 5));
        System.out.println(canPack (0, 5, 4));
        System.out.println(canPack (2, 2, 11));
        System.out.println(canPack (-3, 2, 12));
    }
    // write your code here
    public static boolean canPack(int bigCount, int smallCount, int goal){
        if(bigCount < 0 || smallCount<0 || goal <0){
            return false;
        }

        while(bigCount>0 || smallCount >0){
            int bigBagCapabilities = bigCount * 5;

            if (
                    bigBagCapabilities  == goal ||
                            smallCount == goal ||
                            bigBagCapabilities + smallCount == goal
            ){
                System.out.println(goal + "direct equals");
                return true;
            }

            if (bigBagCapabilities + smallCount < goal){
                System.out.println("capabilites Less than goal");
                return false;
            }

            if (bigBagCapabilities < goal){

                if(bigBagCapabilities + smallCount > goal){
                    System.out.println(goal + "Possible with big bag: " + bigCount + " and small bag: "+ smallCount);
                    return true;
                }
            }

            if (bigCount <= 0){
                smallCount--;
            }else {
                bigCount--;
            }

        }
        return false;
    }
}