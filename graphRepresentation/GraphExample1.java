class GraphExample1{
    private int[][] adjMatrix;
    private int numVertices;
    // In Graph we initialize both the matrix and the no. of vertics inside the Graph Example1 
    public GraphExample1(int numVertices){
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
        GraphExample1 g=new GraphExample1(2); 
        g.addEdge(0, 1); 
        System.out.println("Adjacency Matrix: ");
        g.printMatrix();
    }
}