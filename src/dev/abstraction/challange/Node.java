package dev.abstraction.challange;

public class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

    /**
     * @param listItem {ListItem}
     * @return {int}
     */
    int compareTo(ListItem listItem) {
        if (listItem != null){
            return ((String) listItem.value).compareTo((String) super.getValue());
        }else {
            return -1;  
        }
    }

    ListItem next(){
        return this.rightLink;
    }

    ListItem setNext(ListItem next){
        this.rightLink = next;
        return this.rightLink;
    }

    /**
     * @return
     */
    ListItem previous() {
        return this.leftLink;
    }

    /**
     * @param leftLink
     */
    ListItem setPrevious(ListItem leftLink) {
        this.leftLink  = leftLink;
        return this.leftLink;
    }

}
