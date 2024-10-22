import java.util.LinkedList; 

class GraphAdjList2{
    private LinkedList<Integer>[] adjList; // this array'll store LinkedList<Integer> 
    private int numVertices;
    @SuppressWarnings("unchecked") // To suppress generic array warnings  
    public GraphAdjList2(int numVertices){
        this.numVertices=numVertices; 
        adjList=new LinkedList[numVertices]; 
        // Initializing each list in the array 
        for(int i=0; i<numVertices; i++){
            adjList[i]=new LinkedList<>(); // Each index'll have a LinkedList 
        }
    }
    // Method to add and edge between two vertices 
    public void addEdge(int source, int destination){
        adjList[source].add(destination); // Add edge from source to destination 
        adjList[destination].add(source); // Adding edge in opposite direction for non direeccted graph
    }
    public void printGraph(){
        for(int i=0; i<numVertices; i++){
            System.out.print("Vertex: "+ i+": ");
            for(Integer neighbor: adjList[i]){
                System.out.print(neighbor+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        GraphAdjList2 graph=new GraphAdjList2(3); 
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        System.out.println("Graph with 3 vertices forming a triangle: ");
        graph.printGraph(); 
    }
}