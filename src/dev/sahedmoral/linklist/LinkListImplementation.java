package dev.sahedmoral.linklist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListImplementation {
    public static void main(String[] args) {

        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Dhaka");
        placesToVisit.add(0,"Gazipur");
        System.out.println(placesToVisit);

        addMoreElement(placesToVisit);

        System.out.println(placesToVisit);
        printItinerary3(placesToVisit);
//
//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

    }

    public static void printItinerary4(LinkedList<String>list){

        String previousElm = list.getFirst();
        System.out.printf("Our trip will start from %s%n",previousElm);
        var iterator  = list.listIterator(1);
        while (iterator.hasNext()){
            String elm = iterator.next();
            System.out.printf("-> From %s -> to %s %n",previousElm, elm);
            previousElm = elm;
        }
        System.out.printf("Our trip will end at %s%n",list.getLast());

    }

    public static void printItinerary3(LinkedList<String>list){

        String previousElm = list.getFirst();
        System.out.printf("Our trip will start from %s%n",previousElm);
        Iterator<String> iterator  = list.iterator();
        while (iterator.hasNext()){
            String elm = iterator.next();
            System.out.printf("-> From %s -> to %s %n",previousElm, elm);
            previousElm = elm;
        }
        System.out.printf("Our trip will end at %s%n",list.getLast());

    }

    public static void printItinerary(LinkedList<String> list) {
        System.out.printf("Our trip will start from %s%n",list.getFirst());
        for (int i = 1; i < list.size()-1; i++) {
            System.out.printf("-> From %s -> to %s %n",list.get(i-1), list.get(i));
        }

        System.out.printf("Our trip will end at %s%n",list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {
        String previousElm = list.getFirst();
        System.out.printf("Our trip will start from %s%n",previousElm);

        for (String elm : list){
            System.out.printf("-> From %s -> to %s %n",previousElm, elm);
            previousElm = elm;
        }
        System.out.printf("Our trip will end at %s%n",list.getLast());
    }

    public static void addMoreElement(LinkedList<String> list){
        list.offer("Cox's Bazar");
        list.offerFirst("Chitagong");
        list.offerLast("Potuakhali");


        list.addFirst("Rongpur");

        list.push("Last element 1");
    }

    public  static void removeElements(LinkedList<String> list){
        String s1 = list.remove();
        System.out.printf("%s removed%n", s1);
        String s2 = list.pop();
        System.out.printf("%s removed%n", s2);
        String s3 = list.pollFirst();
        System.out.printf("%s removed%n", s3);
        String s4 = list.pollLast();
        System.out.printf("%s removed%n", s4);


    }
}
