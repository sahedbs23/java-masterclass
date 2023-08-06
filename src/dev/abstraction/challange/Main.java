package dev.abstraction.challange;

public class Main {
    public static void main(String[] args) {

//        System.out.println("2".compareTo("3"));
//        System.out.println("2".compareTo("1"));


                ListItem root = new Node("55");
//        System.out.println(root.compareTo(new Node("56")));
//        System.out.println(root.compareTo(new Node("54")));
        MyLinkedList myLinkedList = new MyLinkedList(root);
        myLinkedList.addItem(new Node("50"));
//        System.out.println(myLinkedList);
        myLinkedList.addItem(new Node("51"));
        myLinkedList.addItem(new Node("52"));
        myLinkedList.addItem(new Node("53"));
        myLinkedList.addItem(new Node("100"));
//        myLinkedList.addItem(new Node("100"));
//        myLinkedList.addItem(new Node("D"));
//        myLinkedList.addItem(new Node("H"));
//        myLinkedList.addItem(new Node("F"));
        myLinkedList.traverse(root);
    }
}
