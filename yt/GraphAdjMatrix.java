package yt;
import java.util.List; 
import java.util.ArrayList; 

public class GraphAdjMatrix {
    private int[][] adjMatrix; 
    private int numOfVertices; 
    GraphAdjMatrix(int numOfVertices){
        this.numOfVertices=numOfVertices; 
        adjMatrix=new int[numOfVertices][numOfVertices];
    }
    // adding edges 
    public void addEdge(int source, int destination){
        adjMatrix[source][destination]=1; 
        adjMatrix[destination][source]=1; 
    }
    public void removeEdge(int source, int destination){
        adjMatrix[source][destination]=0; 
        adjMatrix[destination][source]=0;
    }
    public boolean isEdge(int source, int destination){
        return adjMatrix[source][destination]==1; 
    }
    public int degree(int vertex){
        int degree=0; 
        for(int i=0; i<numOfVertices; i++){
            degree+=adjMatrix[vertex][i]; 
        }
        return degree; 
    }
    public boolean hasSelfLoop(int vertex){
        return adjMatrix[vertex][vertex]==1; 
    }
    public List<Integer> getNeighbors(int vertex){ 
        List<Integer> neighbors=new ArrayList<>(); 
        for(int i=0; i<numOfVertices; i++){ 
            if(adjMatrix[i][vertex]==1){
                neighbors.add(i);
            }
        }
        return neighbors; 
    }
    public void printGraph(){
        for(int i=0; i<numOfVertices; i++){
            System.out.print("Row: "+i+" ");
            for(int j=0; j<numOfVertices; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphAdjMatrix graph=new GraphAdjMatrix(4); 
        // Adding edges 
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        // Pringint the matrix; 
        System.out.println("The adjacency Matrix: "); 
        graph.printGraph();
        System.out.println("The degree of 2: "+graph.degree(2));         
    }
}
