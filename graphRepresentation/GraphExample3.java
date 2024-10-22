public class GraphExample3{
    private int[][] adjMatrix; 
    private int numVertices; 
    public GraphExample3(int numVertices){
        this.numVertices=numVertices; 
        adjMatrix=new int[numVertices][numVertices];
    }
    public void addEdge(int i, int j){
        adjMatrix[i][j]=1; 
        adjMatrix[j][i]=1;
    }
    public void printMatrix(){
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
        System.out.println();
        }
    }
    public static void main(String[] args){
        GraphExample3 g=new GraphExample3(4); // Graph with 4 vertices 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        System.out.println("Adjacency Matrix: ");
        g.printMatrix();
    }
}