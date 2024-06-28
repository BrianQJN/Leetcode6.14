import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-28
 */
public class LC199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        // initialization
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // process the nodes in the queue
            int levelSize = queue.size();
            TreeNode curNode = null;

            for (int i = 0; i < levelSize; i++) {
                // traverse the cur level nodes and record the last one
                curNode = queue.poll();

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            // current node is the right most node in this level
            res.add(curNode.val);
        }

        return res;
    }
}
