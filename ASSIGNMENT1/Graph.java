import java.util.*;

public class Graph {

    // Stores each building and the buildings connected to it.
    private Map<String, List<String>> graph = new LinkedHashMap<>();

    public void addNode(String node) {
        // Adds the building only if it is not already in the graph.
        graph.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String a, String b) {
        // Makes sure both buildings exist before connecting them.
        addNode(a);
        addNode(b);

        // Adds the connection in both directions.
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public List<String> getNeighbors(String node) {
        // Returns all buildings connected to this building.
        return graph.get(node);
    }
}