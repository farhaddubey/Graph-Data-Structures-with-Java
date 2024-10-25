package checked;
import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List; 

public class GraphAdjList {
    private List<LinkedList<Integer>> adjList; 
    private int numOfVertices; // No. of vertices 
    public GraphAdjList(int numOfVertices){
        this.numOfVertices=numOfVertices; 
        adjList=new ArrayList<>(numOfVertices);
        for(int i=0; i<numOfVertices; i++){
            adjList.add(new LinkedList<>()); // Each veretex gets a linkedlist to store it's edges 
        }
    }
    // Adding an edge between two vertices (undirected)
    public void addEdge(int source, int destination){
        adjList.get(source).add(destination); 
        adjList.get(destination).add(source);
    }
    public void removeEdge(int source, int destination){
        adjList.get(source).remove((Integer)destination);// or Integer.valueOf(destination)
        adjList.get(destination).remove((Integer)source);// Integer.valueOf(source)
    }
    public boolean isEdge(int source, int destination){
        return adjList.get(destination).contains(source); // Checking if destinationo contains source or source ontains destination
    }
    public int degree(int vertex){
        return adjList.get(vertex).size(); // Degree is the size of the list for the vertex 
    }
    public boolean hasSelfLoop(int vertex){
        return adjList.get(vertex).contains(vertex); // Checking if vertex has itself in ti's list 
    }
    public List<Integer> getNeighbors(int vertex){
        return new ArrayList<>(adjList.get(vertex)); // Return a copy of the list of the neighbors 
    }
    public void printGraph(){
        for(int i=0; i<numOfVertices; i++){
            System.out.print("Vertex: "+i+": ");
            for(Integer neighbor: adjList.get(i)){
                System.out.print("-->"+neighbor);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphAdjList graph=new GraphAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        System.out.println("Adjacency List Representation: ");
        graph.printGraph();
        // Checking degree of vertex 2 
        System.out.println("Degree of Vertex 2: "+graph.degree(2));
        System.out.println("Neighbor of Vertex 2: "+graph.getNeighbors(2)); 
        System.out.println("Does vertex 2 have a self loop: "+graph.hasSelfLoop(2));
        System.out.println("Is there an edge between verte 1 and 2"+graph.isEdge(1, 3));
        graph.removeEdge(0, 2);

        graph.printGraph();
    }
}
