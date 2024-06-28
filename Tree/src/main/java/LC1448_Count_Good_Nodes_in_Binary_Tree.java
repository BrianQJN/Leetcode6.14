/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-28
 */
public class LC1448_Count_Good_Nodes_in_Binary_Tree {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int good = 0;

        if (node.val >= maxVal) {
            good = 1;
            maxVal = node.val;
        }

        good += countGoodNodes(node.left, maxVal);
        good += countGoodNodes(node.right, maxVal);

        return good;
    }
}
