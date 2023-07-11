// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        byte count = 0;
        byte min = 1;
        short max = 1000;
        for (int i = min; i < max && count<5; i++) {
            if ( (i % 3 == 0) && (i % 5 == 0) ){
                System.out.println(i);
                sum += i;
                count++;
            }
        }
        System.out.println("Sum is =" + sum);
        
        
    }

//        byte myByteMinValue = Byte.MIN_VALUE;
//        byte myByteMaxValue = Byte.MAX_VALUE;
//
//        short myShortMinValue = Short.MIN_VALUE;
//        short myShortMaxValue = Short.MAX_VALUE;
//
//        byte dividedByteValue = (byte) (myByteMinValue / 2);
//
//        int myIntMinValue = Integer.MIN_VALUE;
//        int myIntMaxValue = Integer.MAX_VALUE;
//
//        long longMinVal = Long.MIN_VALUE;
//        long longMaxVal = Long.MAX_VALUE;
//
//        float floatMinValue  = Float.MIN_VALUE;
//        float floatMaxValue  = Float.MAX_VALUE;
//
//        double doubleMinVal = Double.MIN_VALUE;
//        double doubleMaxVal = Double.MAX_VALUE;
//
//        boolean myBoolFalseVal = Boolean.FALSE;
//        boolean myBoolTrueVal = Boolean.TRUE;
//
//        // Press Opt+Enter with your caret at the highlighted text to see how
//        // IntelliJ IDEA suggests fixing it.
//        System.out.print("Hello and welcome!");
//
//        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }
//    }
}