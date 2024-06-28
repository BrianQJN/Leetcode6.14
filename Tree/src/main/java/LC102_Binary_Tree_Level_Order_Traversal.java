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
public class LC102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // initialization
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // process nodes in queue if it is not empty
            int levelSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                // process current level nodes
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);

                // add the next level to the queue if it is not null
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            res.add(curLevel);
        }

        return res;
    }
}
