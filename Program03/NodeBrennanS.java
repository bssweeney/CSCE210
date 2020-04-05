/**
 * Class NodeBrennanS that is used in ListBrennanS
 * @author Brennan Sweeney
 */
public class NodeBrennanS {
    private String value;
    private NodeBrennanS next; 
    private NodeBrennanS prev;
    
    //ctor requires the value; every time a new node is made
    public NodeBrennanS(String value) {
        this.value = value;
    }

    /**
     * Returns the value of the node
     * @return value of the string
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets the next node
     * @return the next value in the list
     */
    public NodeBrennanS getNext() {
        return this.next;
    }

    /**
     * Gets the previous node
     * @return the previous value in the list
     */
    public NodeBrennanS getPrev() {
        return this.prev;
    }

    /**
     * Gets the next node
     * @param n sets the next to n
     */
    public void setNext(NodeBrennanS n) {
        this.next = n;
    }

    /**
     * Gets the previous node
     * @param n sets the previous to n
     */
    public void setPrev(NodeBrennanS n) {
        this.prev = n;
    }
}