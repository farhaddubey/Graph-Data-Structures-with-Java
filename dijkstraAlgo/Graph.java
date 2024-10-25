import java.util.*; 

class Graph{
    private int V; // No. of vertices 
    private LinkedList<Edge>[] adj;
    class Edge{
        int dest, weight; 
        Edge(int dest, int weight){
            this.dest=dest; 
            this.weight=weight;
        }
    }
    Graph(int v){
        V=v;
        adj=new LinkedList[v]; 
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<>(); 
        }
    }
    void addEdge(int src, int dest, int weight){
        adj[src].add(new Edge(dest, weight));
    }
    void dijkstra(int src){
        int[] dist=new int[V]; // Distance Array
        Arrays.fill(dist, Integer.MAX_VALUE); // Initially setting all distances to infinity 
        dist[src]=0;
        PriorityQueue<Edge> pq=new PriorityQueue<>(V, Comparator.comparingInt(edge->edge.weight));
        pq.offer(new Edge(src, 0)); // Starting with the source vertex 
        while(!pq.isEmpty()){
            Edge current=pq.poll(); // Getting the vertex with the smallest distance 
            int u=cu
        }
    }
}


