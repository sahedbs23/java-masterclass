import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        StringFormatter.runMethods();
        StringFormatter.stringPropertyMethods("Hello world");
        StringFormatter.emptyAndBlank("");
        StringFormatter.emptyAndBlank("     \n");
        System.out.println("Hello world".indexOf("H"));
        System.out.println("Hello world".indexOf("H"));

        //    HiredEmployee hiredEmployee = new HiredEmployee(
//            "Sahed Moral",
//            "15-12-1990",
//            123,
//            "01-01-2021",
//            24000,
//            false
//
//    );
//
//    hiredEmployee.retire();

        //        Animal animal = new Animal("Generic Animal", "Big size", 5.0);
//        animalDoStuff(animal, "slow");
//
//        Animal dog = new Dog("Kedi kutta", "small", "not specified", "not mentioned");
//        animalDoStuff(dog, "fast");
//
//        Animal cat = new Dog("","medium","","");
//        animalDoStuff(cat, "fast");

//        Point first = new Point(6, 5);
//        Point second = new Point(3, 1);
//
//        System.out.println("distance(0,0)= " + first.distance());
//
//        System.out.println("distance(second)= " + first.distance(second));
//
//        System.out.println("distance(2,2)= " + first.distance(2, 2));
//
//        Point point = new Point();
//
//        System.out.println("distance()= " + point.distance());

//        Customer defaultCustomer = new Customer();
//
//        System.out.println(defaultCustomer.getName());
//        System.out.println(defaultCustomer.getCreditLimit());
//        System.out.println(defaultCustomer.getEmail());
//
//        Customer sahedCustomer = new Customer("sahed","sahed.moral@123rf.com", 45);
//
//        System.out.println(sahedCustomer.getName());
//        System.out.println(sahedCustomer.getCreditLimit());
//        System.out.println(sahedCustomer.getEmail());
//
//
//        Customer zeroCreditCustomer = new Customer("rejuana","prova@123rf.com");
//
//        System.out.println(zeroCreditCustomer.getName());
//        System.out.println(zeroCreditCustomer.getCreditLimit());
//        System.out.println(zeroCreditCustomer.getEmail());

//        Account sahedAccount = new Account(
//                "572",
//                500.20,
//                "Sahed",
//                "sahed.moral@outlook.com",
//                "(880) 1714 999720"
//        );
//
//        if (sahedAccount.deposit(50)){
//            System.out.println("Balance after deposit : "+sahedAccount.getBalance());
//        }
//
//        if (sahedAccount.withdraw(600)){
//            System.out.println("Balance after withdraw : " + sahedAccount.getBalance());
//        }else {
//            System.out.println("you do noy have sufficient balance");
//        }
//
//        if (sahedAccount.withdraw(200)){
//            System.out.println("Balance after withdraw : " + sahedAccount.getBalance());
//        }else {
//            System.out.println("you do noy have sufficient balance");
//        }
//
//        Account account = new Account();
//        System.out.println(account.getCustomerName());
//
//        Account EblAccount = new Account("sahed","sahed@ebl.com.bd","8801714999720");


//        Car car = new  Car();
//        System.out.println("Model = " + car.getModel());
//        System.out.println("Color = " + car.getColor());
//        car.describeCar();
        //        int currentYear = 2023;
//        try {
//            int age = getUserInputByConsole(currentYear);
//            System.out.println("So you are " + age + " Years old");
//        } catch (NullPointerException e) {
//            int age = getUserInputByScanner(currentYear);
//            System.out.println("So you are " + age + " Years old");
//        }
    }

    public static void animalDoStuff(Animal animal, String speed){

        System.out.println(animal);
        animal.move(speed);
        animal.makeNoise();

        System.out.println("----");
    }

    public static int getUserInputByConsole(int currentYear) {

        String userNameInput = System.console().readLine("What's you name?");

        System.out.println("Welcome " + userNameInput);

        String userInputDateOfBirth = System.console().readLine("What is the year you were born?");

        return currentYear - Integer.parseInt(userInputDateOfBirth);
    }

    public static int getUserInputByScanner(int currentYear) {

        Scanner scanner = new Scanner(System.in);

//        String userNameInput = System.console().readLine("What's you name?");
        System.out.println("What's you name?");
        String userNameInput = scanner.nextLine();
        System.out.println("Welcome " + userNameInput);

//        String userInputDateOfBirth = System.console().readLine("What is the year you were born?");
        int age = 0;
        boolean isValidInput = false;
        System.out.println("What's year were you born?");
        do {
            System.out.println("Enter a year between " + (currentYear - 125) + " and " + currentYear);
            try {
                age = checkUserInput(currentYear, scanner.nextLine());
                isValidInput = age > 0;
            } catch (NumberFormatException badUserInput) {
                System.out.println("Only numeric data is acceptable");
            }
        } while (!isValidInput);

        return age;

    }

    public static int checkUserInput(int currentYear, String userInputDateOfBirth) {
        int dateOfYear = Integer.parseInt(userInputDateOfBirth);
        int minimumAge = currentYear - 125;
        if (dateOfYear < minimumAge || dateOfYear > currentYear) {
            return -1;
        }
        return currentYear - dateOfYear;
    }
//    public static void main(String[] args) {
//        int sum = 0;
//        byte count = 0;
//        byte min = 1;
//        short max = 1000;
//        for (int i = min; i < max && count<5; i++) {
//            if ( (i % 3 == 0) && (i % 5 == 0) ){
//                System.out.println(i);
//                sum += i;
//                count++;
//            }
//        }
//        System.out.println("Sum is =" + sum);
//
//
//    }

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