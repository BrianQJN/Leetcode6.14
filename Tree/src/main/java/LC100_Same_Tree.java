/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-28
 */
public class LC100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base cases
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // recursive check for left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
