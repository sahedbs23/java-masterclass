import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger price is " + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
        System.out.println("Total Healthy Burger price is  " + healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition3("Should not do this", 50.53);
        System.out.println("Total Deluxe Burger price is " + db.itemizeHamburger());


        //        Meal meal = new Meal();
//        meal.printMemo();
//        System.out.println("...".repeat(10));
//
//        Burger deluxBurger = new DeluxeBurger(140);
//        Drink water = new Drink("Water", 'm');
//        ExtraFoodItem cashewNutSalad = new ExtraFoodItem("cashew nut salad", 70);
//
//        deluxBurger.addToppings(3);
//
//        Meal deluxBurgerMeal = new Meal(deluxBurger, water, cashewNutSalad);
//        deluxBurgerMeal.printMemo();
//        System.out.println("...".repeat(10));
//
//        Burger hemBurger = new HamBurger(110);
//        Drink coke = new Drink("Coca cola kan", 's');
//        ExtraFoodItem extraChess = new ExtraFoodItem("Extra Chess", 10);
//        hemBurger.addToppings(2);
//
//        Meal hamburgerPackage = new Meal(hemBurger, coke, extraChess);
//        coke.setSize('L');
//
//        hamburgerPackage.printMemo();




        //        Scanner scanner = new Scanner(System.in);
//        Car myCar;
//        while (true) {
//            System.out.println("What kind of car are you using? Type H for hybrid, G for gas powered car, E for Electric car, Q for quite!");
//            String carType = scanner.nextLine();
//
//            if ("Qq".contains(carType)) {
//                break;
//            }
//            System.out.println("Write a nice description for your car...");
//            String carDescription = scanner.nextLine();
//
//            switch (carType.toLowerCase().charAt(0)) {
//                case 'g' -> {
//                    System.out.println("What is the average speed of you gas powered car?");
//                    String gasCarSpeed = scanner.nextLine();
//
//                    System.out.println("How many cylinder do you car have?");
//                    String cylinderCount = scanner.nextLine();
//                    myCar = new GaspoweredCar(carDescription, Double.parseDouble(gasCarSpeed), Integer.parseInt(cylinderCount));
//                }
//                case 'h' -> {
//                    System.out.println("What is the average speed of you hybrid powered car?");
//                    String gasCarSpeed = scanner.nextLine();
//
//                    System.out.println("How many cylinder do you car have?");
//                    String cylinderCount = scanner.nextLine();
//
//                    System.out.println("How many battery do you car have?");
//                    String batteryCount = scanner.nextLine();
//                    myCar = new HybridCar(carDescription, Double.parseDouble(gasCarSpeed), Integer.parseInt(cylinderCount), Integer.parseInt(batteryCount));
//                }
//                case 'e' -> {
//                    System.out.println("What is the average speed of you Electric car?");
//                    String electricCarSpeed = scanner.nextLine();
//
//                    System.out.println("How many battery do you car have?");
//                    String batteryCount = scanner.nextLine();
//                    myCar = new ElectricCar(carDescription, Double.parseDouble(electricCarSpeed), Integer.parseInt(batteryCount));
//                }
//                default -> {
//                    myCar = new Car(carDescription);
//                }
//            }
//            myCar.startEngine();
//            myCar.runEngine();
//            myCar.drive();
//
//        }

//        Car car = new Car("My Red color Hondai car");
//        car.startEngine();
//        car.drive();
//        car.runEngine();
//
//        Car gaspowredCar = new GaspoweredCar("My White toyota colora",70.5,2);
//        gaspowredCar.startEngine();
//        gaspowredCar.drive();
//        gaspowredCar.runEngine();
//
//
//        Car electricCar = new ElectricCar("Tesla",60,6);
//        electricCar.startEngine();
//        electricCar.drive();
//        electricCar.runEngine();
//
//
//        Car hybridCar = new HybridCar("Toyota Tesla",60,2, 4);
//        hybridCar.startEngine();
//        hybridCar.drive();
//        hybridCar.runEngine();


//        Movie movie = Movie.getMovie("Adventure", "Himalaya");
//        movie.watchMovie();
//
//        Object unknownMovie = Movie.getMovie("Once upon a time in the west", "ScienceFiction");
//        if (unknownMovie.getClass().getSimpleName().equals("Adventure")){
//            ((Adventure) unknownMovie).watchComedyMovie();
//        }else if (unknownMovie instanceof Comedy){
//            ((Comedy) unknownMovie).watchComedyMovie();
//        }else if (unknownMovie instanceof ScienceFiction syfy){
//            syfy.watchScienceFictionMovie();
//        }


        //        Scanner scanner = new Scanner(System.in);
//        while (true){
//            System.out.println("Type s for science fiction movie, Type C for comedy movie, Type A for adventure move, Type q to quit!");
//            String type = scanner.nextLine();
//            if ("Qq".contains(type)){
//                break;
//            }
//            System.out.println("Type movie title");
//            String title = scanner.nextLine();
//            Movie movie = Movie.getMovie(title, type);
//            movie.watchMovie();
//        }

//        Movie movie = Movie.getMovie("Start wards", "sci");
//        movie.watchMovie();

//        Printer printer = new Printer(100, true);
//        System.out.printf("Page printed %d%n", printer.getPagesPrinted());
//
//        int printedPage = printer.printPages(5);
//        System.out.printf("Page provided %d Page printed %d%n",printedPage,printer.getPagesPrinted());
//
//
//        printedPage = printer.printPages(9);
//        System.out.printf("Page provided 8 Page printed %d and total page printed : %d %n",printedPage, printer.getPagesPrinted());

//        Refrigerator iceBox = new Refrigerator(false);
//        CoffeeMaker brewMaster = new CoffeeMaker(false);
//        DishWasher dishWasher = new DishWasher(false);
//
//        SmartKitchen smartKitchen = new SmartKitchen(brewMaster,dishWasher, iceBox);
//        smartKitchen.doKitchenWork();


//        ComputerCase computerCase = new ComputerCase("2208", "Dell","300");
//        Monitor monitor = new Monitor("27Inche Beast", "Acer", 27,"2700 X 1400");
//        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 6, 4, "v2.44");
//
//        PersonalComputer pc = new PersonalComputer("2208", "Dell", monitor,computerCase,motherboard);
////        pc.getComputerCase().pressPowerButton();
////        pc.getMonitor().drawPixel(27,24,"Red");
////        pc.getMotherboard().loadProgram("Linux");
//        pc.powerUp();
        //
//
//
//        StringFormatter.runMethods();
//        StringFormatter.stringPropertyMethods("Hello world");
//        StringFormatter.emptyAndBlank("");
//        StringFormatter.emptyAndBlank("     \n");
//        System.out.println("Hello world".indexOf("H"));
//        System.out.println("Hello world".indexOf("H"));

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

    public static void animalDoStuff(Animal animal, String speed) {

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