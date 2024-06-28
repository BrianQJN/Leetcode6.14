/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-28
 */
public class LC110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        // if left subtree is unbalanced
        if (leftHeight == -1) return -1;

        int rightHeight = calculateHeight(node.right);
        // if right subtree is unbalanced
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
