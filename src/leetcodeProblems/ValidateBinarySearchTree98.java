/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        TreeNode negativeInfinity = new TreeNode(Integer.MIN_VALUE);
        TreeNode negativeInfinity2 = new TreeNode(Integer.MIN_VALUE);


//        TreeNode positiveInfinity = new TreeNode(Integer.MAX_VALUE);
//        TreeNode positiveInfinity2 = new TreeNode(Integer.MAX_VALUE);
//        positiveInfinity.left = positiveInfinity2;

        negativeInfinity.left = negativeInfinity2;

//        TreeNode two = new TreeNode(2);
//        two.setNeighbours(negativeInfinity, positiveInfinity);

        ValidateBinarySearchTree98 ob = new ValidateBinarySearchTree98();
        boolean validBST = ob.isValidBST(negativeInfinity);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {

        Integer min = null, max = null;

        return isValidBSTUtil(root, min, max);

    }

    // Time Complexity - O(N) where N is number of nodes in binary tree
    // Space Complexity - O(N) recursion stack which will become worse i.e., O(N) in case skewed tree
    public boolean isValidBSTUtil(TreeNode root, Integer min, Integer max) {

        if (root == null)
            return true;

        if (min != null && root.val <= min)
            return false;

        if (max != null && root.val >= max)
            return false;

        return isValidBSTUtil(root.left, min, root.val) &&
                    isValidBSTUtil(root.right, root.val, max);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setNeighbours(TreeNode l, TreeNode r) {
            left = l;
            right = r;
        }
    }
}
