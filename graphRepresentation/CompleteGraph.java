import java.util.LinkedList; 

public class CompleteGraph{
    private LinkedList<Integer>[] adjList; // Array of List for adjacency list 
    private int numVertices; 
    // Constructor to initialize the graph 
    @SuppressWarnings("unchecked")
    public CompleteGraph(int numVertices){
        this.numVertices=numVertices; 
        adjList=new LinkedList[numVertices]; // Create array of linkedlist 
        // Initializing each list in the array 
        for(int i=0; i<numVertices; i++){
            adjList[i]=new LinkedList<>(); // Each index will have a LinkedList
        }
    }
    // Method to add an edge between two vertices
    public void addEdge(int source, int destination){
        adjList[source].add(destination);
        adjList[destination].add(source);  // Addinng the no of destination to list of that's source 
    }
    // Method to print the adjacency list 
    public void printGraph(){
        for(int i=0; i<numVertices; i++){
            System.out.print("Vertex "+ i+": ");
            for(Integer neighbor: adjList[i]){
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        CompleteGraph graph=new CompleteGraph(6);
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(0, 3); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        System.out.println("Complete Graph with 4 vertices: ");
        graph.printGraph();
    }
}