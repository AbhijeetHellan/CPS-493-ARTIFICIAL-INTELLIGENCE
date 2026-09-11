import java.util.*;

public class Traversal {

    public static void dfs(Graph graph, String node, Set<String> visited) {
        // Marks the current building as visited.
        visited.add(node);

        // Prints the building being visited.
        System.out.print(node + " ");

        // Checks every building connected to the current building.
        for (String next : graph.getNeighbors(node)) {

            // Visits the next building only if it has not been visited.
            if (!visited.contains(next)) {
                dfs(graph, next, visited);
            }
        }
    }

    public static void bfs(Graph graph, String start) {
        // Keeps track of buildings that were already visited.
        Set<String> visited = new HashSet<>();

        // Stores buildings that still need to be visited.
        Queue<String> queue = new LinkedList<>();

        // Starts BFS from the selected building.
        visited.add(start);
        queue.add(start);

        // Continues until there are no buildings left in the queue.
        while (!queue.isEmpty()) {

            // Removes the next building from the queue.
            String node = queue.remove();

            // Prints the building being visited.
            System.out.print(node + " ");

            // Checks every building connected to the current building.
            for (String next : graph.getNeighbors(node)) {

                // Adds only buildings that have not been visited yet.
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Creates the campus graph.
        Graph campus = new Graph();

        // Adds the campus walkway connections.
        campus.addEdge("SH", "HAB");
        campus.addEdge("SH", "WH");
        campus.addEdge("WH", "LC");
        campus.addEdge("LC", "L");
        campus.addEdge("LC", "SoB");
        campus.addEdge("L", "FH");
        campus.addEdge("L", "AW");
        campus.addEdge("FH", "SU");
        campus.addEdge("SU", "HAB");
        campus.addEdge("AW", "HC");

        // Runs Depth-First Search starting from Science Hall.
        System.out.println("DFS from SH:");
        dfs(campus, "SH", new HashSet<>());

        // Runs Breadth-First Search starting from Science Hall.
        System.out.println("\n\nBFS from SH:");
        bfs(campus, "SH");

        // DFS uses recursion, which works like a stack.
        // BFS uses a queue.
        // DFS time complexity is O(V + E).
        // BFS time complexity is O(V + E).
    }
}
