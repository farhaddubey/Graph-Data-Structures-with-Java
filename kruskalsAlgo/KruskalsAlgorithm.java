package kruskalsAlgo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int source, destination, weight; 
    public Edge(int source, int destination, int weight){
        this.source=source; 
        this.destination=destination; 
        this.weight=weight; 
    }
    @Override
    public int compareTo(Edge other){
        return this.weight-other.weight;
    }
}
public class KruskalsAlgorithm {
    int V; 
    List<Edge> edges = new ArrayList<>(); 
    KruskalsAlgorithm(int V){
        this.V=V; 
    }
    void addEdge(int source, int destination, int weight){
        edges.add(new Edge(source, destination, weight)); 
    }
    int find(int[] parent, int i){
        if(parent[i]==i) return i; 
        return parent[i] = find(parent, parent[i]);
    }
    void union(int[] parent, int[] rank, int x, int y){
        int rootX=find(parent, x);
        int rootY=find(parent, y);
        if(rank[rootX]<rank[rootY]){
            parent[rootX]=rootY; 
        }else if(rank[rootX]>rank[rootY]){
            parent[rootY]=rootX; 
        }else{
            parent[rootY]=rootX; 
            rank[rootX]++;
        }
    }
    void kruskalMST(){
        Collections.sort(edges); 
        int[] parent=new int[V]; 
        int[] rank=new int[V]; 
        for(int i=0; i<V; i++){
            parent[i]=i; 
            rank[i]=0;
        }
        List<Edge> result=new ArrayList<>(); 
        for(Edge edge: edges){
            int x=find(parent, edge.source);
            int y=find(parent, edge.destination);
            if(x!=y){
                result.add(edge);
                union(parent, rank, x, y);
            }
        }
        System.out.println("Edge \t Weight"); 
        for(Edge edge: result){
            System.out.println(edge.source+" - "+edge.destination+"\t"+edge.weight);
        }
    }
    public static void main(String[] args){
        KruskalsAlgorithm graph=new KruskalsAlgorithm(5); 
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 1);
        graph.kruskalMST();
    }
    
}
