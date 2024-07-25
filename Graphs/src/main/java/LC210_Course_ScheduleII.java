import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-24
 */
public class LC210_Course_ScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create adjacency list represents the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();

        // preform dfs on each node
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited, onPath, order)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(numCourses - 1 - i);
        }

        return res;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onPath, List<Integer> order) {
        if (onPath[node]) {
            return true; // cycle detected
        }

        if (visited[node]) {
            return false; // already visited, no cycle found
        }

        visited[node] = true;
        onPath[node] = true;

        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visited, onPath, order)) {
                return true;
            }
        }

        onPath[node] = false;
        order.add(node);

        return false;
    }
}
