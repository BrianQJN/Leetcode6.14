/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-27
 */
public class LC226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        // edge case
        if (root == null) return null;

        // recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }
}
