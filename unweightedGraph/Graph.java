import java.util.*; 

class Graph{
    private int V; // No. of verties 
    private LinkedList<Integer>[] adj; 
    Graph(int v){
        V=v; 
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v); // Since it's an undirected graph 
    }
    void shortestPath(int src){
        int[] dist=new int[V]; // Distance Array 
        Arrays.fill(dist, Integer.MAX_VALUE); // Initializing distance to infinity
        dist[src]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            int node=queue.poll(); // Dequeue a vertex 
            for(int neighbor: adj[node])}{
                if(dist[neighbor]==Integer.MAX_VALUE){
                    dist[neighbor]=dist[node]+1;
                    queue.add(neighbor);
                }
            }
            // Printing shortest distance 
            System.out.println("Vertex Distance from sourcee: ");
            for(int i=0; i<V; i++){
                System.out.println(i+"\t\t"+dist[i]);
            }
        }
        public static void main(String[] args){
            Graph g=new Graph(6);
            g.addEdge(0, 1); 
            g.addEdge(0, 2); 
            g.addEdge(1, 3); 
            g.addEdge(2, 4); 
            g.addEdge(3, 5); 
            g.addEdge(4, 5);
            g.shortestPath(0); // Finding shortest path from A (index 0)
        }
}