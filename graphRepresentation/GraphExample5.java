public class GraphExample5{
    private int numVertices; 
    private int[][] adjMatrix; 
    public GraphExample5(int numVertices){
        this.numVertices=numVertices; 
        adjMatrix=new int[numVertices][numVertices];
    }
    private void addEdge(int i, int j){
        adjMatrix[i][j]=1; 
        adjMatrix[j][i]=1;
    }
    private void delete(int i, int j){
        adjMatrix[i][j]=0; 
        adjMatrix[j][i]=0;
    }
    private void print(){
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphExample5 g=new GraphExample5(4);
        g.addEdge(0, 1); 
        g.addEdge(1, 3); 
        g.addEdge(3, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        System.out.println("Adjacency Matrix: ");
        g.print();
    }
    
}