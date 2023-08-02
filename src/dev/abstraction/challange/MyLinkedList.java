package dev.abstraction.challange;

public class MyLinkedList implements  NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root){
        this.root = root;
    }
    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem listItem) {

//        ListItem
//        ListItem temp = root;
//        while (temp != null){
//            int val = temp.compareTo(listItem); // b
//            if (val > 0){
//                temp.setPrevious(listItem);
//                return true;
//            }else if (val <0){
//                temp.setNext(listItem);
//                return true;
//            }else {
//                return false;
//            }
////            temp = root.next();
//        }
        return false;

    }

    @Override
    public boolean removeItem(ListItem listItem) {
        root.next().setNext(listItem);
        return true;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println(root.getValue());
        traverse(root.previous());
        traverse(root.next());
    }
}
