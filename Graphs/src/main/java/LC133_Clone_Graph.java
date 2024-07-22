import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-20
 */
public class LC133_Clone_Graph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // if the node was already visited, return the clone node from the hash map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // create a clone for the given node
        Node cloneNode = new Node(node.val, new ArrayList<>());

        visited.put(node, cloneNode);

        // iterate through the neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
