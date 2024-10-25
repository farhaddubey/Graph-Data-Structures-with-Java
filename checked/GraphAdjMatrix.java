package checked;
import java.util.ArrayList; 
import java.util.List; 

public class GraphAdjMatrix {
    private int[][] adjMatrix; // 2D array for storing edges between vertices 
    private int numVertices; 
    public GraphAdjMatrix(int numVertices){
        this.numVertices=numVertices; 
        adjMatrix=new int[numVertices][numVertices]; 
    }    
    // Method to add an edge between the node i and j 
    public void addEdge(int i, int j){
        adjMatrix[i][j]=1;
        adjMatrix[j][i]=1;
    }
    public void removeEdge(int i, int j){
        adjMatrix[i][j]=0;
        adjMatrix[j][i]=0;
    }
    // Method to check if theere's an edge between i & j
    public boolean isEdge(int i, int j){
        return adjMatrix[i][j]==1;
    }
    public void printMatrix(){
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
    // Method to calculate the degree of given vertex as "vertex"
    public int degree(int vertex){
        int degree=0; 
        for(int i=0; i<numVertices; i++){
            degree+=adjMatrix[i][vertex]; // summing up all connectioons(1s) in the given row for the given vertex
        }
        return degree; 
    } 
    // Method to check if a vertex has a self-loop (edge to itself)
    public boolean hasSelfLoop(int vertex){
        return adjMatrix[vertex][vertex]==1; // Self loop only exists if the diagonal element is 1
    }
    // Method to get all the neighbours of a vertex 
    public List<Integer> getNeighbors(int vertex){
        List<Integer> neighbors=new ArrayList<>(); // List to store neighbors 
        for(int i=0; i<numVertices; i++){
            if(adjMatrix[i][vertex]==1){
                neighbors.add(i);
            }
        }
        return neighbors;
    }
    public static void main(String[] args){
        GraphAdjMatrix graph=new GraphAdjMatrix(4);
        System.out.println("Graph creation begins: ");
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        // Printing the adjacency matrix 
        System.out.println("The matrix is: ");
        graph.printMatrix();
        System.out.println("The degree is: ");
        System.out.println(graph.degree(2));
        System.out.println("The neighbours of 2 are: ");
        System.out.println(graph.getNeighbors(2));
        System.out.println("Status of 2's self loop: ");
        System.out.print(graph.hasSelfLoop(2));
        System.out.println("Is there an edge between vertex 1 and 3: ");
        graph.removeEdge(0, 2);
        System.out.println("Adjacency Matrix after removing edge (0, 2): ");
        graph.printMatrix();
    }

}
