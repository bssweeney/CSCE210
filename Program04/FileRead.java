import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads the file and creates it to the graph
 * @author Brennan Sweeney
 */
public class FileRead {
    public static final String DELIMS = "[ ]+";
    private int numVerts;

    /**
     * Reading a file and creating the graph
     * @param file takes a file reads it and creates a graph with it
     * @return the graph that I created
     * @throws IOException incase the file that is used is does not exsist
     */
    public GraphBrennanS readFile(String file) throws IOException {
        GraphBrennanS graph;
        Scanner scanner = new Scanner(new FileReader(file));
        String line; 
        
        //sets the first line to the numbers of vertexes
        line = scanner.nextLine();
        numVerts = Integer.parseInt(line);

        //reads the second line
        line = scanner.nextLine();

        //reads the third line
        line = scanner.nextLine();

        //creating the graph with numVerts
        graph = new GraphBrennanS(numVerts);

        //while loop for the rest of the file
        while(scanner.hasNextLine()) {
            String[] split = line.split(DELIMS);
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);
            graph.addEdge(v1, v2, weight);
            line = scanner.nextLine();
        }
        scanner.close();
        return graph;
    }
}