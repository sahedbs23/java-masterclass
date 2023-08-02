package dev.sahedmoral.linklist.LinkListChallenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkListChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printInput();
        var placesToVisit  = createLinkList();
        var listIterator = placesToVisit.listIterator();
        boolean loop = true;
        while (listIterator.hasNext() && loop){
            String userInput = scanner.nextLine();
            switch (userInput.toLowerCase().charAt(0)){
            case 'f' -> printCityInfo(listIterator.next());
            case 'b' -> printPrevios(listIterator);
            case 'l' -> listPlaces(placesToVisit);
            case 'm' -> printInput();
            default -> loop = false;
            }
        }
    }

    private static void printPrevios(ListIterator<City> listIterator){
        if (listIterator.hasPrevious()){
            printCityInfo(listIterator.previous());
        }else {
            System.out.println("No Previous record found");
        }
    }

    private static void listPlaces(LinkedList<City> cityLinkedList){
        for (City city : cityLinkedList) {
            printCityInfo(city);
        }
    }

    private static void printCityInfo(City city){
        System.out.printf("%s %d %n",city.getTown(), city.getDistance());
    }

    private static void printInput(){
        String message = """
                Available actions. Select word or letters
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """;
        System.out.println(message);
    }

    private static LinkedList<City> createLinkList(){
        LinkedList<City> cityLinkedList = new LinkedList<>();
        cityLinkedList.offer(new City("Melbourne", 877));
        cityLinkedList.offer(new City("Brisbane", 917));
        cityLinkedList.offer(new City("Adelaide", 1374));
        cityLinkedList.offer(new City("Alice springs", 2771));
        cityLinkedList.offer(new City("Perth", 3923));
        cityLinkedList.offer(new City("Darwin", 3972));
        return  cityLinkedList;
    }
}
