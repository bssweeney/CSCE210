/**
 * List class that creates a linked list that implements List210
 * @author Brennan Sweeney
 */
public class ListBrennanS implements List210 {
    private NodeBrennanS head;
    private NodeBrennanS tail;

    /**
     * copy ctor
     * @param copy copys the list
     */
    public ListBrennanS(ListBrennanS copy) {
        this.head = null;
        this.tail = null;

        NodeBrennanS n = copy.head; 
        while(n != null) {
            String s = n.getValue();
            this.addToEnd(s);
            n = n.getNext();
        }
    }
    /**
     * default ctor
     */
    public ListBrennanS() {}

    /**
     * Method that can add to the end of the list
     */
    public void addToEnd(String str) {
        NodeBrennanS n = new NodeBrennanS(str);
        //case 1: empty list
        if(head == null) {
            head = n;
            tail = n;
        }
        //case 2: add to end of the exsiting list
        else {
            n.setPrev(tail);
            tail.setNext(n);
            tail = n;
        }
    }

    /**
     * Adds a string to the end of the list
     */
    public void addToBeginning(String str) {
        NodeBrennanS n = new NodeBrennanS(str);
        //case 1: empty list
        if(head == null) {
            head = n;
            tail = n;
        }
        //case 2: add to beginning of the exsisting list
        else {
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
    }

    /**
     * gets a node from the list
     * @return true if it is in the list
     */
    public boolean get(String item) {
        NodeBrennanS n = head; 
        while(n != n.getNext()) {
            if(n.getValue().equals(item)) {
                break;
            }
            n = n.getNext();
        }
        return true;
    }

    /**
     * Gets a node from the list
     */
    public String get(int i) {
        int count = 1;
        NodeBrennanS n = head; 
        while(count != i) {
            count++;
            n = n.getNext();
            if(head == null) {
                return null;
            }
        }
        return n.getValue();
    }

    /**
     * removes a node from the list
     */
    public boolean remove(String item) {
        NodeBrennanS n = head;
        while(n != null) {
            if(n.getValue().equals(item)) {
                removeNode(n);
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    /**
     * removes a node from the list
     */
    public boolean remove(int i) {
        int count = 1;
        NodeBrennanS n = head; 
        while(n != null) {
            count++;
            n = n.getNext();
            if(count == i) {
                removeNode(n);
                return true;
            }
        }
        return false;
    }

    /**
     * reverses the list
     */
    public void reverse() {
        NodeBrennanS n = head;
        while(n != null) {
            NodeBrennanS hold = n.getNext();
            NodeBrennanS tmp = n.getNext();
            n.setNext(n.getPrev());
            n.setPrev(tmp);
            n = hold;
        }
        NodeBrennanS tmp = head;
        head = tail;
        tail = tmp;
    }

    /**
     * returns the value of the head of the list
     */
    public String getFirst() {
        String s = null;
        if(head != null) {
            s = head.getValue();
        }
        return s;
    }
    public String getLast() {
        String s = null;
        if(tail != null) {
            s = tail.getValue();
        }
        return s;
    }

    /**
     * returns the number of items in the list
     */
    public int numItems() {
        int count = 0;
        NodeBrennanS n = head; 
        while(n != null) {
            count++;
            n = n.getNext();
        }
        return count;
    }

    /**
     * clears the list
     */
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * returns true if list is Empty 
     * false otherwise
     */
    public boolean isEmpty() {
        if(head == null) {return true;}
        else {
            return false;
        }    
    }

    /**
     * removes nodes from the list
     * @param n takes n and removes n
     */
    private void removeNode(NodeBrennanS n) {
        //first case
        if(head == tail) {
            head = tail = null;
        }
        //second case
        else if(n == head) {
            head = n.getNext();
            head.setPrev(null);
        }
        //thrid case
        else if(n == tail) {
            tail = n.getPrev();
            tail.setNext(null);
        }
        //final case
        else {
            NodeBrennanS before = n.getPrev();
            NodeBrennanS after = n.getNext();
            before.setNext(after);
            after.setPrev(before);
        }
    }
}