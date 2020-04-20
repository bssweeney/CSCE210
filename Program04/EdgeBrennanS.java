/**
 * An Edge class that implements Edge210
 * @author Brennan Sweeney
 */
public class EdgeBrennanS implements Edge210 {
    private int vert1;
    private int vert2;
    private double weight;

    /**
     * Initializes the edge.
     * @param v1 is the first vertex in the edge
     * @param v2 is the second vertex in the edge
     * @param weight is the weight of the edge
     */
    EdgeBrennanS(int vert1, int vert2, double weight) {
        this.vert1 = vert1; 
        this.vert2 = vert2; 
        this.weight = weight;
    }

    /**
     * Gets the first vertex in the edge
     * @return the first vertex
     */
    public int getVert1() {
         return vert1;
    }

    /**
     * Gets the second vertex in the edge
     * @return the second vertex
     */
    public int getVert2() {
        return vert2;
    }

    /**
     * Gets the weight in the edge
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the "other" vertex in the edge
     * @param v This vert
     * @return Returns the other vert; if v is not on the edge, then vert1 is returned
     */
    public int otherVert(int v) {
        if(v == vert1) {return vert2;}
        else {
            return vert1;
        }
    }

    /**
     * Returns true if vert is part of the edge.
     * @param v The vert to check
     * @return Returns true if part of edge
     */
    public boolean hasVert(int v) {
        if(v == vert1 || v == vert2) {
            return true;
        }
        else {
            return false;
        }
    }

}