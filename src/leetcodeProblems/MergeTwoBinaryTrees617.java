/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {


    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null)
            return null;

        int sum = 0;

        if (t1 != null)
            sum += t1.val;


        if (t2 != null)
            sum += t2.val;

        TreeNode node = new TreeNode(sum);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return node;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
