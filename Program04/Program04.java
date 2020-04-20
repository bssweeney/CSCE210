import java.io.IOException;

/**
 * The main() class for Program04, CSC 210 Spring 2020.
 * @author Brennan Sweeney
 */
public class Program04 {

  /**
   * This main() tests some graphs
   * @param args unused
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    System.out.println("Hello, P4");

    PrimMST mst = new PrimMST();
    FileRead fr = new FileRead();

    //creating test2
    // GraphBrennanS graph = new GraphBrennanS(2);
    // graph.addEdge(0, 1, 1);

    //creating test3
    // GraphBrennanS graph = new GraphBrennanS(3);
    // graph.addEdge(0, 1, 11);
    // graph.addEdge(1, 2, 2);
    // graph.addEdge(2, 0, 3);
    
    GraphBrennanS graph = fr.readFile("/Users/bsswe/OneDrive/Documents/Java Programs/Program04/graphs/1000EWG.txt");

    GraphBrennanS mstGraph = mst.Prims(graph, 0);

    System.out.println(mstGraph);

  }
}