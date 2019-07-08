/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

public class EvaluateExpressionTree {

    public static void main(String[] args) {

        TreeNode plus = new TreeNode("+");
        TreeNode multiply = new TreeNode("*");
        TreeNode subtract = new TreeNode("-");
        TreeNode division = new TreeNode("/");
        TreeNode five = new TreeNode("5");
        TreeNode four = new TreeNode("4");
        TreeNode hundred = new TreeNode("100");
        TreeNode tweenty = new TreeNode("20");
        TreeNode two = new TreeNode("2");


        plus.setChildren(multiply, subtract);
        multiply.setChildren(five, four);
        subtract.setChildren(hundred, division);
        division.setChildren(tweenty, two);

        int result = evaluateExpressionTree(plus);
        System.out.println(result);
    }


    //Source - https://www.geeksforgeeks.org/evaluation-of-expression-tree/
    private static int evaluateExpressionTree(TreeNode root) {
        if (root == null)
            return 0;


        if (root.c.equals("+")) {
            return evaluateExpressionTree(root.left) + evaluateExpressionTree(root.right);
        }

        if (root.c.equals("-")) {
            return evaluateExpressionTree(root.left) - evaluateExpressionTree(root.right);
        }

        if (root.c.equals("*")) {
            return evaluateExpressionTree(root.left) * evaluateExpressionTree(root.right);
        }

        if (root.c.equals("/")) {
            return evaluateExpressionTree(root.left) / evaluateExpressionTree(root.right);
        }

        return Integer.parseInt(root.c);
    }

    static class TreeNode {
        String c;
        TreeNode left;
        TreeNode right;

        public TreeNode(String c) {
            this.c = c;
        }

        public void setChildren(TreeNode l, TreeNode r) {
            this.left = l;
            this.right = r;
        }
    }
}
