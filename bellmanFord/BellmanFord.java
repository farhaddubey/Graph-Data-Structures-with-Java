package bellmanFord;

class Edge{
    int source, destination, weight;
    Edge(int source, int destination, int weight){
        this.source=source; 
        this.destination=destination; 
        this.weight=weight;
    }
}
public class BellmanFord {
    int V; 
    int E; 
    Edge[] edges; 

    BellmanFord(int v, int e){
        V=v; 
        E=e; 
        edges = new Edge[E];
    }
    void addEdge(int edgeIndex, int source, int destination, int weight){
        edges[edgeIndex]=new Edge(source, destination, weight);
    }
    void bellmanFord(int src){
        int[] distance = new int[V]; 
        // Step 1: Initializing distances from source to all other vertices as INFINITE 
        for(int i=0; i<V; i++){
            distance[i]=Integer.MAX_VALUE; 
        }
        distance[src]=0;

        // Step 2: Relaxing all edges from |V| - 1 times 
        for(int i=1; i<=V-1; i++){
            for(int j=0; j<E; j++){
                int u=edges[j].source; 
                int v=edges[j].destination; 
                int weight=edges[j].weight;
                if(distance[u]!=Integer.MAX_VALUE && distance[u]+weight<distance[V]){
                    distance[v]=distance[u]+weight; 
                }
            }
        }

        // Step 3: Checking for negative cycles 
        for(int j=0; j<E; j++){
            int u=edges[j].source; 
            int v=edges[j].destination; 
            int weight=edges[j].weight; 
            if(distance[u]!=Integer.MAX_VALUE && distance[u]+weight < distance[v]){
                System.out.println("Graph contains negative weight cycles.");
                return; 
            }
        }

        // Printing all distances 
        printSolution(distance);
    }
    void printSolution(int[] distance){
        System.out.println("Vertex distances from source: ");
        for(int i=0; i<V; i++){
            System.out.println(i+"\t\t"+distance[i]);
        }
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Corrected the number of edges to match the edges being added
        BellmanFord graph = new BellmanFord(V, E);

        // Adding edges correctly within the specified range of 8 edges
        graph.addEdge(0, 0, 1, -1);
        graph.addEdge(1, 0, 2, 4);
        graph.addEdge(2, 1, 2, 3);
        graph.addEdge(3, 1, 3, 2);
        graph.addEdge(4, 1, 4, 2);
        graph.addEdge(5, 3, 2, 5);
        graph.addEdge(6, 3, 1, 1);
        graph.addEdge(7, 4, 3, -3);
        
        // Run Bellman-Ford algorithm starting from vertex 0
        graph.bellmanFord(0); 
    }
}
