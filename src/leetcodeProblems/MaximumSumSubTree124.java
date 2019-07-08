package leetcodeProblems;

public class MaximumSumSubTree124 {
    public static void main(String[] args) {

        MaximumSumSubTree124 ob = new MaximumSumSubTree124();

        TreeNode negativeTen = new TreeNode(-10);
        TreeNode nine = new TreeNode(9);
        TreeNode tweenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        negativeTen.setNeighbours(nine, tweenty);
        tweenty.setNeighbours(fifteen, seven);


//        TreeNode one = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//        one.setNeighbours(two, null);
//        two.setNeighbours(three, null);
//        three.setNeighbours(four, null);
//        four.setNeighbours(five, null);


        int maxPathSum = ob.maxPathSum(negativeTen);
        System.out.println(maxPathSum);

    }

    int maximumSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode root) {

        if (root == null)
            return 0;

        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);

        int maxSumWithCurrentNodeAsRoot = root.val + left + right;

        //maximumSum take care of keeping track of new path with current root and root of subtree
        maximumSum = Math.max(maxSumWithCurrentNodeAsRoot, maximumSum);

        // not considering either one of sub tree child
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;

        maxGain(root);
        return maximumSum;
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
