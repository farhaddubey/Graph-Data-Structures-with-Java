package yt;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphDFS {
    private Map<Integer, List<Integer>> adjList; 
    public GraphDFS(){
        adjList=new HashMap<>();
    }
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u);
    }
    public void DFS(int startNode){
        Set<Integer> visited=new HashSet<>(); // Creating a set for visited array 
        System.out.print("DFS Traversal: ");
        DFSUtil(startNode, visited);
    }
    // Utility method to perform DFS recursively 
    private void DFSUtil(int node, Set<Integer> visited){
        visited.add(node); 
        System.out.print(node+" ");
        for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains((neighbor))){
                DFSUtil(neighbor, visited);
            }
        }
    }
    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            System.out.println("Node "+entry.getKey()+" is connected to: "+entry.getValue());
        }
    }
    public static void main(String[] args){
        GraphDFS graph = new GraphDFS(); 
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.DFS(0);
        
    }
    
}
