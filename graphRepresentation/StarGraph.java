import java.util.LinkedList; 
@SuppressWarnings("unchecked")

public class StarGraph{
    private LinkedList<Integer>[] adjList; // Array of lists for adjacency list 
    private int numVertices; 
    public StarGraph(int numVertices){
        this.numVertices=numVertices; 
        adjList=new LinkedList[numVertices]; // Create array of LinkedList
        for(int i=0; i<numVertices; i++){
            adjList[i]=new LinkedList<>(); // Each index will have a LinkedList
        }
    }
    public void addEdge(int source, int destination){
        adjList[source].add(destination); 
        adjList[destination].add(source);
    }
    // Method to print the adjacency list 
    public void printGraph(){
        for(int i=0; i<numVertices; i++){
            System.out.print("Vertex: "+i+": ");
            for(Integer neighbor: adjList[i]){
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        StarGraph graph=new StarGraph(7); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(0, 3); 
        graph.addEdge(0, 4); 
        graph.addEdge(0, 5); 
        graph.addEdge(0, 6); 
        System.out.println("Star Graph: "); 
        graph.printGraph();
    }
}