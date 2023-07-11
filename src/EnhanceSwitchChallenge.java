public class EnhanceSwitchChallenge {

    public static void main(String[] args) {
        int day = 6;
        printDayOfTheWeek(day);
        printDayOfTheWeekIfElse(day);
        printNumberInWord(0);
        System.out.println(getDaysInMonth(2,2002));
    }

    public static void printDayOfTheWeek(int day) {
        String dayOfTheWeek = switch (day) {
            case 0 ->  "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Not found";
        };
        System.out.println(dayOfTheWeek);
    }

    public static void printDayOfTheWeekIfElse(int day) {
        if (day == 0) {
            System.out.println("Sunday");
        } else if (day == 1) {
            System.out.println("Monday");
        } else if (day == 2) {
            System.out.println("Tuesday");
        } else if (day == 3) {
            System.out.println("Wednesday");
        } else if (day == 4) {
            System.out.println("Thursday");
        } else if (day == 5) {
            System.out.println("Friday");
        } else if (day == 6) {
            System.out.println("Saturday");
        } else {
            System.out.println("Not found");
        }
    }

    public static void printNumberInWord(int number) {
        switch (number) {
            case 0 -> System.out.println("ZERO");
            case 1 -> System.out.println("ONE");
            case 2 -> System.out.println("TWO");
            case 3 -> System.out.println("THREE");
            case 4 -> System.out.println("FOUR");
            case 5 -> System.out.println("FIVE");
            case 6 -> System.out.println("SIX");
            case 7 -> System.out.println("SEVEN");
            case 8 -> System.out.println("EIGHT");
            case 9 -> System.out.println("NINE");
            default -> System.out.println("OTHER");

        }
    }

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }

        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        if (year < 1 || year > 9999) {
            return -1;
        }

        int days;
        switch (month) {
            case 2 :
                days = isLeapYear(year) ? 29 : 28;
                break;
            case 1 :
            case 4 :
            case 6 :
            case 8 :
            case 10 :
            case 12 :
                days =  31;
            break;
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = -1;
                break;
        };
        return days;

    }

}
