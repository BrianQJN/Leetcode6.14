/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-28
 */
public class LC104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
