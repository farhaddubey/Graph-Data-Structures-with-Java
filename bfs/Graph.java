import java.util.*; 

class Graph{
    private Map<Integer, List<Integer>> adjList; // Adjacency List Representation 
    public Graph(){
        adjList=new HashMap<>();
    }
    // Adding edge to the Graph
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v); 
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u);
    }
    public void BFS(int startNode){
        Queue<Integer> queue=new LinkedList<>(); 
        Set<Integer> visited=new HashSet<>();
        // Start by adding the first node to the queue and marking it as Visited 
        queue.add(startNode);
        visited.add(startNode);
        System.out.print("BFS Traversal: ");
        while(!queue.isEmpty()){
            int currentNode=queue.poll(); // Deque the current Node 
            System.out.print(currentNode+" ");
            // Traversing all the neighbors of the current Node 
            for(int neighbor: adjList.getOrDefault(currentNode, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor); // Marking neighbour as visited 
                    queue.add(neighbor);
                }
            }
        }
    }
    // Priting Graph for debugging 
    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            System.out.println("Node: "+entry.getKey()+" is connected to: "+entry.getValue());
        }
    }
    public static void main(String[] args){
        Graph graph=new Graph();
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2);
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 5); 
        graph.addEdge(2, 6);
        graph.printGraph(); // Printing the adjacency list 
        graph.BFS(0);
    }
}