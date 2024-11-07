import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set; 

public class GraphBFS {
    private final Map<Integer, List<Integer>> adjList; 
    public GraphBFS(){
        adjList=new HashMap<>(); 
    }    
    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, x->new ArrayList<>()).add(v); 
        adjList.computeIfAbsent(v, x->new ArrayList<>()).add(u); 
    }
    public void BFS(int startNode){
        Queue<Integer> queue=new ArrayDeque<>(); 
        Set<Integer> visited=new HashSet<>(); 
        queue.add(startNode); 
        visited.add(startNode); 
        System.out.println("BFS Traversal "); 
        while(!queue.isEmpty()){
            int currentNode=queue.poll(); 
            System.out.print(currentNode+"--->"); 
            List<Integer> neighbors=adjList.get(currentNode); // getting th adj List 
            if(neighbors!=null){
                for(int neighbor: neighbors){
                    if(visited.add(neighbor)){
                        queue.add(neighbor); 
                    }
                }
            }
        }
    }
    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            System.out.println("Node: "+entry.getKey()+"is connected to neighbors: "+entry.getValue());
        }
    }
    public static void main(String[] args){
        GraphBFS bfs=new GraphBFS(); 
        bfs.addEdge(0, 1); 
        bfs.addEdge(0, 2); 
        bfs.addEdge(1, 3); 
        bfs.addEdge(1, 4); 
        bfs.addEdge(2, 5); 
        bfs.addEdge(2, 6); 
        bfs.printGraph(); 
        bfs.BFS(0);
    }
}
