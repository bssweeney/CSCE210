import java.util.Random;

/**
 * Wheel class that utalizes ListBrennanS 
 * @author Brennan Sweeney
 */
public class WheelBrennanS {
    private String name;
    private ListBrennanS items;
    private ListBrennanS reloadItems;
    private boolean stillSpinning;

    /**
     * default ctor
     */
    public WheelBrennanS() {
        name = "tmp";
        items = new ListBrennanS();
        reloadItems = null;
        stillSpinning = false;
    }

    /**
     * Reloads the list
     */
    public void reload() {
        if(reloadItems != null) {
            items = new ListBrennanS(reloadItems);
        }
    }

    /**
     * Gets the name of the wheel
     * @return the name of the wheel
     */
    public String getName() {
        return name;
    }

    /**
     * sets name as a string
     * @param s is equal to name
     */
    public void setName(final String s) {
        name = s;
    }

    /**
     * get a random item from the list
     * @return the random item 
     */
    public String getRandomItem() {
        if(items.getFirst() == null) {
            return null;
        }
        else {
            Random rand = new Random();
            int r = rand.nextInt(items.numItems()) + 1;
            String n = items.get(r);
            return n;
        }
    }

    /**
     * Reverse the items in the list
     */
    public void reverse() {
        items.reverse();
    }

    /**
     * New method that gets the string value of the certain spot on the list
     * @param i takes i location of the list
     * @return the string value that is found at i. 
     */
    public String get(int i) {
        String s = items.get(i);
        return s;
    }

    /**
     * adds an item to the list
     * @param str is the item that is added
     */
    public void addItem(final String str) {
        items.addToEnd(str);
        stillSpinning = false;
    }
    
    /**
     * removes an item from the list
     * @param str is the item removed
     */
    public void removeItem(String str) {
        items.remove(str);
    }

    /**
     * Gets the first item in the list
     * @return the first item
     */
    public String getFirstItem() {
        return items.getFirst();

    }

    /**
     * Gets the last item in the list
     * @return the last item 
     */
    public String getLastItem() {
        return items.getLast();
    }

    //prints the items in the list
    public void print() {
        for(int i = items.numItems(); i > 0; i-- ) {
            String n = items.get(i);
            System.out.print(n + ", " );
       }
    }

    /**
     * method for spinning the wheel removes item selected
     * @return the string value selected.
     */
    public String spin() {
        if(! stillSpinning) {
            reloadItems = new ListBrennanS(items);
        }
        stillSpinning = true;
        String s = getRandomItem();
        removeItem(s);
        return s;
    }

    /**
     * Returns the number of elements in the list
     * @return the number of elements in the list
     */
    public int getSizeItem() {
        int n = items.numItems();
        return n;
    }

    /**
     * clears all items from the list
     */
    public void clear() {
        items.clear();
    }
}