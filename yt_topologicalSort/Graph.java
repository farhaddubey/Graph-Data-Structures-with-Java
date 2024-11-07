import java.util.*;

public class Graph {
    private int numOfVertices; 
    private List<List<Integer>> adjList; 
    public Graph(int numOfVertices){
        this.numOfVertices=numOfVertices; 
        adjList=new ArrayList<>(numOfVertices); 
        for(int i=0; i<numOfVertices; i++){
            adjList.add(new ArrayList<>()); 
        }
    }
    public void addEdge(int v, int w){
        adjList.get(v).add(v); 
    }
    public List<Integer> topologicalSort(){
        Deque<Integer> stack =new ArrayDeque<>(); 
        boolean[] visited=new boolean[numOfVertices]; 
        // Now performing DFS for each unvisited vertex 
        for(int i=0; i<numOfVertices; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack); 
            }
        }
        List<Integer> topologicalOrder=new ArrayList<>(stack); 
        return topologicalOrder; 
    }
    private void topologicalSortUtil(int V, boolean[] visited, Deque<Integer> stack){
        visited[V]=true; 
        for(int neighbor: adjList.get(V)){
            if(!visited[neighbor]){
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(V);
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
        List<Integer> topologicalOrder=g.topologicalSort(); 
        topologicalOrder.forEach(vertex->System.out.print(vertex+"---->"));
    }
    
}
