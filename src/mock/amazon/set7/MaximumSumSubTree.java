/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.amazon.set7;

public class MaximumSumSubTree {

    public static void main(String[] args) {

        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode negativeTen = new TreeNode(-10);
        TreeNode tweenty = new TreeNode(20);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode fifteen = new TreeNode(15);
        TreeNode four = new TreeNode(4);
        TreeNode thirteen = new TreeNode(13);
        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode nine = new TreeNode(9);


//        negativeTen.left = nine;
//        negativeTen.right = tweenty;
//        tweenty.left = fifteen;
//        tweenty.right = seven;
//        one.left = two;
//        one.right = three;

//        two.left = one;
//        two.right= three;

//        five.left = one;
//        five.right = four;
//        four.left = three;
//        four.right = six;

        MaximumSumSubTree ob = new MaximumSumSubTree();

        int sum = ob.maxPathSum(negativeTen);
        System.out.println(sum);

    }

    public int maxPathSum(TreeNode root) {

//        if (root.left == null && root.right == null && root.val < 0) {
//            return root.val;
//        }

        return maxPathSumUtil(root);
    }

    public int maxPathSumUtil(TreeNode root) {

        if (root == null)
            return Integer.MIN_VALUE;

        int leftMaxSum = maxPathSumUtil(root.left);

        if(leftMaxSum==Integer.MIN_VALUE){
            leftMaxSum = root.val;
        }

        int rightMaxSum = maxPathSumUtil(root.right);

        if(rightMaxSum==Integer.MIN_VALUE){
            rightMaxSum = root.val;
        }

        // only left
        int onlyLeft = leftMaxSum;

        // only right
        int onlyRight = rightMaxSum;

        // left+root
        int leftWithRoot = onlyLeft + root.val;

        // right + root
        int rightWithRoot = onlyRight + root.val;


        // left + root.+right
        int all = onlyLeft + onlyRight + root.val;

        return Math.max(onlyLeft, Math.max(onlyRight, Math.max(leftWithRoot, Math.max(rightWithRoot, all))));
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
