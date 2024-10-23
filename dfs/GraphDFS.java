import java.util.*; 
class GraphDFS{
    private Map<Integer, List<Integer>> adjList; 
    public GraphDFS(){
        adjList=new HashMap<>(); 
    }
    // Adding edge to the graph 
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v); 
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u);
    }
    // DFS Method --->(recursive) 
    public void DFS(int startNode){
        Set<Integer> visited=new HashSet<>(); 
        System.out.println("DFS Traversal: ");
        DFSUtil(startNode, visited); // recursive 
    }
    private void DFSUtil(int node, Set<Integer> visited){
        visited.add(node); // Marking node as visited 
        System.out.print(node+" "); 
        // Exploring all unvisited neighbors recursively  
        for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                DFSUtil(neighbor, visited); // Recursive call for the neighbor
            }
        }
    }
    // Printing Graph for debugging 
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
        graph.addEdge(2, 6);
        graph.printGraph(); // Printing the adjacency list 
        // Perform DFS starting from node 0
        graph.DFS(0);
    }
}