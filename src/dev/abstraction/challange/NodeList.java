package dev.abstraction.challange;

public interface NodeList {
    public abstract ListItem getRoot();
    public abstract boolean addItem(ListItem listItem);

    public abstract boolean removeItem(ListItem listItem);
    public abstract void traverse(ListItem listItem);
}
