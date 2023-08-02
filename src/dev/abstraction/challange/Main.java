package dev.abstraction.challange;

public class Main {
    public static void main(String[] args) {
        ListItem listItem = new Node("B");
        listItem.setNext(new Node("C"));
        listItem.setPrevious(new Node("A"));
        System.out.println(listItem.previous().getValue());
        System.out.println(listItem.getValue());
        System.out.println(listItem.next().getValue());
        System.out.println(listItem.compareTo(new Node("D")));
    }
}
