package mock.amazon.set3;

public class ValidateBST {
    public static void main(String[] args) {

        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode thirteen = new TreeNode(13);
        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

//        two.left = one;
//        two.right= three;

        five.left = one;
        five.right = four;
        four.left = three;
        four.right = six;

        ValidateBST ob = new ValidateBST();
        boolean validBST = ob.isValidBST(five);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, null, null);
    }

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
    }
}
