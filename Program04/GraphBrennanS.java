import java.util.ArrayList;

/**
 * Graph class that takes edges and vertexes and creates a graph.
 * @author Brennan Sweeney
 */
public class GraphBrennanS implements Graph210 {
    private ArrayList<Edge210> edgeList;
    private int numVerts;

    /**
     * Initializes the graph
     * @param numVerts takes the number of verts in the graph
     */
    public GraphBrennanS(int numVerts) {
        this.numVerts = numVerts;
        edgeList = new ArrayList<>();
    }

    /**
     * returns the number of edges in the graph
     */
    public int numVerts() {
        return numVerts;
    }

    /**
     * returns the number of edges in the graph
     */
    public int numEdges() {
        return edgeList.size();
    }

    /**
     * Adds an edge to the graph.
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @param weight the weight of the edge
     * @return the edge that was added to the graph
     */
    public Edge210 addEdge(int v1, int v2, double weight) {
        EdgeBrennanS edge = new EdgeBrennanS(v1, v2, weight);
        edgeList.add(edge);
        return edge;
    }

    /**
     * Returns a list of edges connected to the vertex.
     * @param v The vertex
     * @return Returns a list of edges connected to the vertex
     */
    public ArrayList<Edge210> edges(int v) {
        ArrayList<Edge210> retList = new ArrayList<>();

        //loop that goes for each edge in the edge list
        for(Edge210 e : this.edgeList) {
            if(e.getVert1() == v) {
                retList.add(e);
            }
            if(e.getVert2() == v && e.getVert1() != e.getVert2()) {
                retList.add(e);
            }
        }        
        return retList;
    }

    /**
     * Returns a Arraylist of all edges in the graph.
     * @return a copy of of the list of edges
     */
    public ArrayList<Edge210> allEdges() {
        return new ArrayList<Edge210>(edgeList);
    }

    /**
     * overriding the toString for GraphBrennanS
     * @return the String to print out
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(numVerts + "\n");
        sb.append(numEdges() + "\n");
        for(Edge210 e : this.edgeList) {
            sb.append(e.getVert1() + ", " + e.getVert2() + ", " + e.getWeight() + "\n");
        }
        return sb.toString();
    }

}