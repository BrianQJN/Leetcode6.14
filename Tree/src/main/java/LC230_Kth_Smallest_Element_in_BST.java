/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-29
 */
public class LC230_Kth_Smallest_Element_in_BST {
    private int count = 0;
    private int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return res;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            res = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }
}