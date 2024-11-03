package primsAlgo;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.naming.LinkLoopException;
import javax.naming.LinkRef;

class Edge{
    int destination; 
    int weight; 
    Edge(int destination, int weight){
        this.destination=destination; 
        this.weight=weight;
    }
}
public class PrimsAlgorithm {
    private int V; // Number of vertices 
    private LinkedList<Edge>[] adjList; 
    PrimsAlgorithm(int numOfVertices){
        adjList=new LinkedList[V];
        for(int i=0; i<V; i++){
            adjList[i]=new LinkedList<>();
        }
    }
    void addEdge(int source, int destination, int weight){
        adjList[source].add(new Edge(destination, weight)); 
        adjList[destination].add(new Edge(destination, weight));// Undirected graph 
    }
    void primsMST(){
        boolean[] inMST=new boolean[V]; 
        int[] key=new int[V]; 
        int[] parent=new int[V]; 
        Arrays.fill(key, Integer.MAX_VALUE); 
        Arrays.fill(parent, -1);
        // Priority Qeueu to store vertices by smallest key value 
        PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparingInt(e->e.weight));
        key[0]=0; // Startign from vertex 0 
        pq.add(new Edge(0, key[0]));
        while(!pq.isEmpty()){
            int u=pq.poll().destination;
            // Markign u as part of MST
            inMST[u]=true;
            // Processing all adjacent vertices of u 
            for(Edge edge: adjList[u]){
                int v=edge.destination; 
                int weight=edge.weight; 
                if(!inMST[v] && weight<key[v]){
                    key[v] = weight; 
                    pq.add(new Edge(v, key[v])); 
                    parent[v]=u;
                }
            }
        }
        // Printing MST edges 
        System.out.println("Edge \t Weight: ");
        for(int i=1; i<V; i++){
            System.out.println(parent[i]+ " - "+i+"\t"+key[i]);
        }
    }
    public static void main(String[] args){
        PrimsAlgorithm graph=new PrimsAlgorithm(5); 
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 1);
        graph.primsMST();
    }
    
}
