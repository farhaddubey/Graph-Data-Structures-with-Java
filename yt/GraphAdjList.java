package yt;
import java.util.List; 
import java.util.LinkedList; 
import java.util.ArrayList; 

public class GraphAdjList {
    private List<LinkedList<Integer>> adjList; 
    private int numOfVertices; 
    public GraphAdjList(int numOfVertices){
        this.numOfVertices=numOfVertices; 
        adjList=new ArrayList<>(numOfVertices); 
        for(int i=0; i<numOfVertices; i++){
            adjList.add(new LinkedList<>());
        }
    }
    // Adding Edges 
    public void addEdge(int source, int destination){
        adjList.get(source).add(destination); 
        adjList.get(destination).add(source);
    }
    // Removing Edges 
    public void removeEdge(int source, int destination){
        adjList.get(source).remove((Integer)destination); 
        adjList.get(destination).remove((Integer) source); 
    }
    // if having edge bn source dest
    public boolean isEdge(int source, int destination){
        return adjList.get(source).contains(destination); 
    }
    // degree ie. total no of nodes connected 
    public int degree(int vertex){
        return adjList.get(vertex).size();
    }
    public boolean hasSelf(int vertex){
        return adjList.get(vertex).contains(vertex);
    }
    public List<Integer> getNeighbors(int vertex){
        return new ArrayList<>(adjList.get(vertex));
    }
    public void printGraph(){
        for(int i=0; i<numOfVertices; i++){
            System.out.print("Vertex: "+i+" ");
            for(Integer neighbor: adjList.get(i)){
                System.out.print("->"+neighbor); 
            }
            System.out.println(); 
        }
    }
    public static void main(String[] args){
         GraphAdjList graph=new GraphAdjList(5); 
         // Edges ccreation 
         graph.addEdge(0, 1);
         graph.addEdge(0, 2);
         graph.addEdge(1, 3);
         graph.addEdge(2, 4);
         graph.addEdge(3, 4);
         // Printing the adjacncy graph 
         System.out.println("Printing the graph: ");
         graph.printGraph(); 
         System.out.println("The degree of the graph is: "+graph.degree(2));
         System.out.println("The neighbours are: "+graph.getNeighbors(2)); 

    }
    
}
