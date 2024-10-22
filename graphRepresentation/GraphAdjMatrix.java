import java.util.Scanner; 

public class GraphAdjMatrix {
    private int[][] adjMatrix;
    private int numVertices; 
    public GraphAdjMatrix(int numVertices){
        this.numVertices=numVertices; // initialized no. of vertices 
        adjMatrix=new int[numVertices][numVertices]; // 
    }
    // Adding edge 
    public void addEdge(int i, int j){
        adjMatrix[i][j]=1; 
        adjMatrix[j][i]=1; // Since it's an undirected Graph 
    }
    // Remove Edge 
    public void removeEdge(int i, int j){
        adjMatrix[i][j]=0; 
        adjMatrix[j][i]=0;
    }
    // Priniting the matrix 
    public void printMatrix(){
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphAdjMatrix g=new GraphAdjMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        System.out.println("Adjacency Matrix: ");
        g.printMatrix();
    }
}