import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class UnWeightedShortestPath {
    private int numOfVertices; 
    private List<List<Integer>> adjList; // Adjacency List 
    
    // Constructor to initialize graph with given number of vertices
    public UnWeightedShortestPath(int numOfVertices) {
        this.numOfVertices = numOfVertices; 
        adjList = new ArrayList<>(numOfVertices);
        
        // Initialize adjacency list for each vertex
        for (int i = 0; i < numOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    
    // Method to add an undirected edge to the graph
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination); 
        adjList.get(destination).add(source);
    }
    
    // BFS method to find the shortest path from a given start vertex
    public void bfsShortestPath(int start) {
        int[] distance = new int[numOfVertices]; // Array to store distances
        Arrays.fill(distance, -1); // Initialize distances to -1 (indicating unvisited)
        
        Queue<Integer> queue = new ArrayDeque<>(); // Queue for BFS
        distance[start] = 0; // Distance to start node itself is 0
        queue.add(start); // Enqueue the start node
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // Dequeue a node
            
            // Explore all adjacent nodes
            for (int neighbor : adjList.get(currentNode)) {
                if (distance[neighbor] == -1) { // If neighbor is unvisited
                    distance[neighbor] = distance[currentNode] + 1; // Update distance
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }

        // Print the shortest distances from the start node
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < numOfVertices; i++) {
            System.out.println("Distance to node " + i + ": " + distance[i]);
        }
    }
    
    // Main method to run the BFS shortest path algorithm
    public static void main(String[] args) {
        UnWeightedShortestPath graph = new UnWeightedShortestPath(6); // Create a graph with 6 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfsShortestPath(0); // Find shortest paths from node 0
    }
}
