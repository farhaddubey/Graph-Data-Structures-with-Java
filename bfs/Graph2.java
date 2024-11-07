import java.util.*;

class Graph2 {
    private final Map<Integer, List<Integer>> adjList; // Adjacency List Representation

    public Graph2() {
        adjList = new HashMap<>();
    }

    // Adding edge to the graph
    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
    }

    // Optimized BFS function
    public void BFS(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>(); // Use ArrayDeque for better performance
        Set<Integer> visited = new HashSet<>();     // Track visited nodes

        // Start by adding the first node to the queue and marking it as visited
        queue.add(startNode);
        visited.add(startNode);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // Dequeue the current node
            System.out.print(currentNode + " ");
            // Traverse all neighbors of the current node
            List<Integer> neighbors = adjList.get(currentNode); // Access neighbors directly
            if (neighbors != null) { // Only if neighbors exist
                for (int neighbor : neighbors) {
                    if (visited.add(neighbor)) { // Adding  and checking at one step  if it's visited or not. in one step
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    // Printing graph for debugging
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println("Node: " + entry.getKey() + " is connected to: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Graph2 graph = new Graph2();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.printGraph(); // Print the adjacency list
        graph.BFS(0);       // Perform BFS traversal
    }
}
