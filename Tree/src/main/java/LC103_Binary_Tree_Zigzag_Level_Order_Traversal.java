import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-29
 */
public class LC103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // initialization
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            // process nodes in cur level
            int curLevelSize = queue.size();

            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.poll();

                if (leftToRight) {
                    curLevel.add(curNode.val);
                } else {
                    curLevel.add(0, curNode.val);
                }

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            res.add(curLevel);
            leftToRight = !leftToRight;
        }

        return res;
    }
}
