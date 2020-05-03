package leetcodeProblems.easy;

public class LowestCommonAncestorInBST235 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root == p || root == q)
            return root;

        if ((root.val > p.val && root.val < q.val) ||
                (root.val > q.val && root.val < p.val))
            return root;

        if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
