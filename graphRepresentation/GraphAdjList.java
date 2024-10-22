import java.util.LinkedList; 

class GraphAdjList{
    private LinkedList<Integer>[] adjList; 
    private int numVertices; 
    // Constructor 
    public GraphAdjList(int numVertices){
        this.numVertices=numVertices; 
        adjList = new LinkedList[numVertices]; 
        // Initializing each vertex's adjacency list 
        for(int i=0; i<numVertices; i++){
            adjList[i]=new LinkedList<>(); 
        }
    }
    // Adding Edge 
    public void addEdge(int i, int j){
        adjList[i].add(j);
        adjList[j].add(i); // Since it's an undirected graph 
    }
    // Printing adjacency List 
    public void printGraph(){
        for(int i=0; i<numVertices; i++){
            System.out.println("Vertex "+i+":");
            for(Integer v: adjList[i]){
                System.out.print("-> "+v);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphAdjList g=new GraphAdjList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3); 
        g.addEdge(2, 3);
        System.out.println("Adjacency List: ");
        g.printGraph();
    }
}