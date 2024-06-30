import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-29
 */
public class LC297_Serialize_and_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // remove the trailing comma
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode cur = queue.poll();

            if (!nodes[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(cur.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(cur.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        LC297_Serialize_and_Deserialize_Binary_Tree codec = new LC297_Serialize_and_Deserialize_Binary_Tree();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        // TreeNode deserializedRoot = codec.deserialize(serialized);
        // String reserialized = codec.serialize(deserializedRoot);
        // System.out.println("Reserialized tree: " + reserialized);
    }
}
