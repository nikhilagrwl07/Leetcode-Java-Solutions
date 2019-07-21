/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

public class LargestBSTInBinaryTree333 {
    public static void main(String[] args) {

        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

//        ten.setNeighbours(five, fifteen);
//        five.setNeighbours(one, eight);
//        fifteen.setNeighbours(null, seven);

        TreeNode three = new TreeNode(3);;
        TreeNode two = new TreeNode(2);;
        three.setNeighbours(null, one);
        one.setNeighbours(two, null);

        LargestBSTInBinaryTree333 ob = new LargestBSTInBinaryTree333();
        int largestBSTSubtree = ob.largestBSTSubtree(three);
        System.out.println(largestBSTSubtree);

    }

    public int largestBSTSubtree(TreeNode root) {

        boolean isBinarySearchTree = isBinarySearchTree(root);

        if (isBinarySearchTree) {
            return countNodes(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));

    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    public boolean isBinarySearchTree(TreeNode root) {

        return isBinarySearchTreeUtil(root, null, null);
    }

    public boolean isBinarySearchTreeUtil(TreeNode root, Integer min, Integer max) {

        if (root == null)
            return true;

        if (min != null && min >= root.val) {
            return false;
        }

        if (max != null && max <= root.val) {
            return false;
        }

        return isBinarySearchTreeUtil(root.left, min, root.val) &&
                isBinarySearchTreeUtil(root.right, root.val, max);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setNeighbours(TreeNode l, TreeNode r) {
            this.left = l;
            this.right = r;
        }
    }
}
