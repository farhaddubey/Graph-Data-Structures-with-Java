class GraphExample4{
    private int[][] adjMatrix; 
    private int numVertices; 
    public GraphExample4(int numVertices){
        this.numVertices=numVertices;
        adjMatrix=new int[numVertices][numVertices];
    }
    public void addEdge(int i, int j){
        adjMatrix[i][j]=1; 
        adjMatrix[j][i]=1;
    }
    public void removeEdge(int i, int j){
        adjMatrix[i][j]=0; 
        adjMatrix[i][j]=0; 
    }
    public void printMatrix(){
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphExample4 g=new GraphExample4(4); 
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(2, 3); 
        g.addEdge(3, 0);
        System.out.println("Adjacency Matrix: ");
        g.printMatrix();
    }
}