package yt;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphBFS {
    private Map<Integer, List<Integer>> adjList; 
    public GraphBFS(){
        adjList=new HashMap<>();
    }
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v); 
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u); 
    }
    public void BFS(int startNode){
        Queue<Integer> queue=new LinkedList<>(); 
        Set<Integer> visited=new HashSet<>(); 
        queue.add(startNode); 
        visited.add(startNode); 
        System.out.println("BFS Traversal: "); 
        while (!queue.isEmpty()) {
            int currentNode=queue.poll(); 
            System.out.print(currentNode+" ");
            // Now traversing all the nodes of the current Node 
            for(int neighbor: adjList.getOrDefault(currentNode, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor); 
                    queue.add(neighbor);
                }
            }
        }
    }
    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            System.out.println("Node: "+entry.getKey()+" is connected to: "+entry.getValue());
        }
    }
    public static void main(String[] args){
        GraphBFS graph=new GraphBFS(); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 0); 
        graph.addEdge(1, 3);
        graph.printGraph(); 
        graph.BFS(0);
    }
}
