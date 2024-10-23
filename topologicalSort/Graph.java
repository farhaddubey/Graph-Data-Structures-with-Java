import java.util.*; 

// Class to represent a directed graph
class Graph{
    private int V; // No. of vertices 
    private LinkedList<Integer> adj[]; // Adjacency List for each vertex 
    Graph(int V){
        this.V=V; 
        adj=new LinkedList[V];
        for(int i=0; i<V; i++){
            adj[i]=new LinkedList();
        }
    }
    // Function to add an edge into the graph 
    void addEdge(int v, int w){
        adj[v].add(w);
    }
    // A recursive function used by topologicalSort 
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack){
        visited[v]=true; // Markign the current node as visited 
        // Recursion for all the vertices adjacent to this vertex 
        for(Integer i: adj[v]){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v); // PUshing current vertex to stack which stores the result
    }
    // The function to perform topological sort 
    void topologicalSort(){
        Stack<Integer> stack=new Stack<>();
        // Marking all the vertices as not visited 
        boolean visited[]=new boolean[V];
        Arrays.fill(visited, false);
        // Calling the recursive helper function to store the topological sort starting from all vertixes one by one
        for(int i=0; i<V; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        // Printing the stack as that contains the topological sorted order 
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }
    public static void main(String[] args){
        Graph g=new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1); 
        System.out.println("Topological Sort: ");
        g.topologicalSort(); 
    }
}