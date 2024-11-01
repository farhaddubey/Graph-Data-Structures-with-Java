package graphRecursive2;
import java.util.*; 

public class GraphDFS {
    private Map<Integer, List<Integer>> adjList; // To store adjacency list, Integer & List 
    public GraphDFS(){
        adjList=new HashMap<>(); // Initializing adjacency list as a HashMap
    }
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v); 
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u);
    }
    public void DFS(int startNode){
        Set<Integer> visited=new HashSet<>(); // To keep track of the visited nodes, creating a set or array 
        System.out.println("DFS Traversal: "); 
        DFSUtil(startNode, visited);
    }
    // Helper method & the recursive part 
    private void DFSUtil(int node, Set<Integer> visited){
        visited.add(node); // Marking thee node as visited 
        System.out.print(node+"-->"); // Printing the current Node 
        // Exploriing the neighbor fo the current node 
        for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(neighbor)){// if neighbor is not in the visited set, ie. neighbor is not visited so let's visit
                DFSUtil(neighbor, visited);
            }
        }
    }
    // Helper Method to print graph 
    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            System.out.println("Node "+entry.getKey()+" is connected to: "+entry.getValue());
        }
    }
    public static void main(String[] args){
        GraphDFS graph=new GraphDFS(); 
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.printGraph();
        graph.DFS(0);
    }
}
