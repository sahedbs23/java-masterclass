package dev.abstraction.challange;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem listItem);

    boolean removeItem(ListItem listItem);
    void traverse(ListItem listItem);
}
