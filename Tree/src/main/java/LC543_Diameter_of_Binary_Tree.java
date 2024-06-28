/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-28
 */
public class LC543_Diameter_of_Binary_Tree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // update the diameter if the path through the current node is longer
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
