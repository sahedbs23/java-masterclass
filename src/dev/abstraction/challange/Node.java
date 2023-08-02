package dev.abstraction.challange;

public class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

    /**
     * @param listItem {ListItem}
     * @return {int}
     */
    @Override
    public int compareTo(ListItem listItem) {
        if (listItem != null){
            return ((String) listItem.value).compareTo((String) super.getValue());
        }else {
            return -1;  
        }
    }

    @Override
    public ListItem next(){
        return this.rightLink;
    }

    @Override
    public ListItem setNext(ListItem next){
        this.rightLink = next;
        return this.rightLink;
    }

    /**
     * @return
     */
    @Override
    public ListItem previous() {
        return this.leftLink;
    }

    /**
     * @param leftLink
     */
    @Override
    public ListItem setPrevious(ListItem leftLink) {
        this.leftLink  = leftLink;
        return this.leftLink;
    }

}
