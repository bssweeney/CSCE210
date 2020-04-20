import java.util.Comparator;

/**
 * The Comparator for Edges that organizes them to smallest first then larger
 * @author Brennan Sweeney
 */
public class EdgeComparator implements Comparator<Edge210> {

    /**
     * Takes edge 1 and compares edge 2
     * the return depends on which if statement is true
     */
    public int compare(Edge210 e1, Edge210 e2) {
        if(e1.getWeight() > e2.getWeight()) {
            return 1;
        }
        else if(e1.getWeight() < e2.getWeight()) {
            return -1;
        }
        else {
            return 0;
        }
    }  
}