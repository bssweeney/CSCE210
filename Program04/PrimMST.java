import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Prim's Min Spanning Tree class that takes a graph and then creates a new graph
 * @author Brennan Sweeney
 */
public class PrimMST { 

    /**
     * Runs prim's algorithm on a graph and a starting point
     * @param graph the graph that is having prim ran on
     * @param start the start vertex for prims
     * @return the new graph 
     */
    public GraphBrennanS Prims(GraphBrennanS graph, int start) {
        boolean[] marked = new boolean[graph.numVerts()];
        ArrayList<Edge210> mstEdges = new ArrayList<>();
        PriorityQueue<Edge210> pq = new PriorityQueue<Edge210>(new EdgeComparator());

        //setting each vertex to marked false
        for(int i = 0; i < graph.numVerts(); i++){
            marked[i] = false;
        }

        visit(start, graph, pq, marked);
        while(! pq.isEmpty()) {
            Edge210 edge = pq.remove();
            int v1 = edge.getVert1();
            int v2 = edge.getVert2();
            if(! marked[v1] || ! marked[v2]) {
                mstEdges.add(edge);
            }
            visit(v1, graph, pq, marked);
            visit(v2, graph, pq, marked);
        }

        //creating the new graph
        GraphBrennanS mstGraph = run(mstEdges);
        return mstGraph;
    }

    /**
     * takes a list and creates a new graph with it
     * @param mstList the list for the method
     * @return the new graph
     */
    private GraphBrennanS run(ArrayList<Edge210> mstList) {
        GraphBrennanS mstGraph = new GraphBrennanS(mstList.size() + 1);
        
        for(Edge210 e : mstList) {
            int v1 = e.getVert1();
            int v2 = e.getVert2(); 
            double weight = e.getWeight();

            mstGraph.addEdge(v1, v2, weight);
        }
        return mstGraph; 
    }

    /**
     * visiting the vertexes in the graph and checks if it has been marked
     * if it is not then find the vertexs connected to it and add them to the pq
     * @param vert starting vert
     * @param graph the graph in order to find the connected vertexes
     * @param pq adding the edges to it
     * @param marked checks if it is marked, and then will mark it true at the end
     */
    private void visit(int vert, GraphBrennanS graph, PriorityQueue<Edge210> pq, boolean[] marked) {
        if(marked[vert] == true) {return;}
        ArrayList<Edge210> list = graph.edges(vert);
        for(Edge210 e : list) {
            pq.add(e);
        }
        marked[vert] = true;
    }
}