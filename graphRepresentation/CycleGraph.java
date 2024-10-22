import java.util.LinkedList; 

@SuppressWarnings("unchecked")
public class CycleGraph{
    private int numVertices; 
    private LinkedList<Integer>[] adjList;  // Declaration 
    public CycleGraph(int numVertices){
        this.numVertices=numVertices; 
        adjList=new LinkedList[numVertices]; // Memory Allocated 
        for(int i=0; i<numVertices; i++){
            adjList[i]=new LinkedList<>(); // Every array no. in the list now contains a LinkedList 
        }
    }
    public void addEdge(int source, int destination){
        adjList[source].add(destination); 
        adjList[destination].add(source);
    }
    public void printGraph(){
        for(int i=0; i<numVertices; i++){
            System.out.print("Vertex: "+ i+ " ");
            for(Integer vert: adjList[i]){
                System.out.print(vert+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        CycleGraph graph=new CycleGraph(6);
        graph.addEdge(0, 1); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
        graph.addEdge(4, 5); 
        System.out.println("Cycle graph with 5 vertics: ");
        graph.printGraph();
    }
}