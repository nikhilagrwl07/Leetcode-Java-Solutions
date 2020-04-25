/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems.medium;

public class LargestBSTInBinaryTree333 {
    public static void main(String[] args) {

        //        TreeNode one = new TreeNode(1);
//        TreeNode eight = new TreeNode(8);
//        TreeNode five = new TreeNode(5, one, eight);
//        TreeNode seven = new TreeNode(7);
//        TreeNode fifteen = new TreeNode(15, null, seven);
//        TreeNode ten = new TreeNode(10, five, fifteen);
//        int largestBSTSubtree = ob.largestBSTSubtree(ten);
//        System.out.println(largestBSTSubtree);

//        TreeNode two = new TreeNode(2, null, null);
//        TreeNode one = new TreeNode(1, two, null);
//        int largestBSTSubtree = ob.largestBSTSubtree(one);
//        System.out.println(largestBSTSubtree);

//        TreeNode two = new TreeNode(2, null, null);
//        TreeNode one = new TreeNode(1, null, two);
//        int largestBSTSubtree = ob.largestBSTSubtree(one);
//        System.out.println(largestBSTSubtree);

//        TreeNode one = new TreeNode(1, null, null);
//        TreeNode three = new TreeNode(3, one, null);
//        TreeNode two = new TreeNode(2, three, null);
//        int largestBSTSubtree = ob.largestBSTSubtree(two);
//        System.out.println(largestBSTSubtree);

        TreeNode four = new TreeNode(4, null, null);
        TreeNode two = new TreeNode(2, null, four);

        TreeNode one = new TreeNode(1, two, null);
        TreeNode three = new TreeNode(3, one, null);

        LargestBSTInBinaryTree333 ob = new LargestBSTInBinaryTree333();
        int largestBSTSubtree = ob.largestBSTSubtree(three);
        System.out.println(largestBSTSubtree);

    }

    private int max = 0;

    // Time Complexity - O(N) where N is number of nodes
    // Space Complexity - O(N) where N is number of nodes
    // Bottom Up approach
    private int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (root.val > left[2] && root.val < right[1]) {
            int cur = left[0] + right[0] + 1;
            max = Math.max(cur, max);
            return new int[]{cur, Math.min(left[1], root.val), Math.max(right[2], root.val)};
        }
        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE};
    }

    // Time Complexity - O(N*N) where N is number of nodes
    // Top down approach
//    public int largestBSTSubtree(TreeNode root) {
//
//        boolean isBinarySearchTree = isBinarySearchTree(root);
//
//        if (isBinarySearchTree) {
//            return countNodes(root);
//        }
//
//        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
//
//    }
//
//    private int countNodes(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        return 1 + countNodes(root.left) + countNodes(root.right);
//
//    }
//
//    public boolean isBinarySearchTree(TreeNode root) {
//
//        return isBinarySearchTreeUtil(root, null, null);
//    }
//
//    public boolean isBinarySearchTreeUtil(TreeNode root, Integer min, Integer max) {
//
//        if (root == null)
//            return true;
//
//        if (min != null && min >= root.val) {
//            return false;
//        }
//
//        if (max != null && max <= root.val) {
//            return false;
//        }
//
//        return isBinarySearchTreeUtil(root.left, min, root.val) &&
//                isBinarySearchTreeUtil(root.right, root.val, max);
//
//    }

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

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
