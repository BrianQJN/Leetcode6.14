import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-25
 */
public class LC261_Graph_Valid_Tree {
    public boolean validTree(int n, int[][] edges) {
        // create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // check if the graph has no cycles and is fully connected
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }

        // check if fully connected
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, graph, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}
