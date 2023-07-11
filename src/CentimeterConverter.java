public class CentimeterConverter {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(66));
        System.out.println(convertToCentimeters(5, 6));
    }

    public static double convertToCentimeters(int inches){
        return inches * 2.54;
    }

    public static double convertToCentimeters(int feet, int inches){
        return convertToCentimeters((feet * 12) + inches);
    }

}
