/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-29
 */
public class LC124_Binary_Tree_Maximum_Path_Sum {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // recursively get the maximum gain from the left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // if choose cur node as highest node
        int newPathSum = node.val + leftGain + rightGain;

        // update the maximum path sum
        maxPathSum = Math.max(maxPathSum, newPathSum);

        // return the maximum gain through cur node, since we can only choose one side to reach higher level
        return node.val + Math.max(leftGain, rightGain);
    }
}
