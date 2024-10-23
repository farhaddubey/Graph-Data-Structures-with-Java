import java.util.*; 

public class GraphDFS2{
    private Map<Integer, List<Integer>> adjList; 
    public GraphDFS2(){
        adjList=new HashMap<>(); // Interger, ArrayList 
    }
    // Adding edge to the graph 
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v); 
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u); 
    }
    // DFS Method 
    public void DFS(int startNode){
        Set<Integer> visited=new HashSet<>(); // As it stores unique values 
        System.out.println("DFS Traversal: ");
        DFSUtil(startNode, visited); 
    }
    // Utility method to perform DFS recursively 
    private void DFSUtil(int node, Set<Integer> visited){
        visited.add(node); // Mark the node as visited 
        System.out.print(node+" ");
        // Exploring all unvisited neighbours recursively 
        for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                DFSUtil(neighbor, visited); // Recursive call for the neighbor 
            }
        }
    }
    // Printing graph for debugging 
    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            System.out.println("Node: "+entry.getKey()+" is connected to: "+entry.getValue());
        }
    }
    public static void main(String[] args){
        GraphDFS2 graph=new GraphDFS2(); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 5); 
        graph.addEdge(2, 6);
        graph.printGraph();// Printing the adjacency list 
        graph.DFS(0);
    }
}