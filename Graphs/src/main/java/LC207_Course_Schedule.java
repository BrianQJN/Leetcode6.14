import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-23
 */
public class LC207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adjacency list represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // add prerequisites courses of each course
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        // keep track of visited node
        boolean[] visited = new boolean[numCourses];
        // keep track of nodes in the cur DFS path
        boolean[] onPath = new boolean[numCourses];

        // perform dfs on each node
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited, onPath)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onPath) {
        // if node is already on the cur path, we found a cycle which is impossible to complete courses
        if (onPath[node]) {
            return true;
        }

        // if we have already visited this node and found no cycle, return false
        if (visited[node]) {
            return false;
        }

        // mark node as visited and add to cur path
        visited[node] = true;
        onPath[node] = true;

        // check all neighbors
        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visited, onPath)) {
                return true;
            }
        }

        // remove node from cur path
        onPath[node] = false;

        return false;
    }
}
