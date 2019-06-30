
package leetcodeProblems;

public class CousinsInBinaryTree993 {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);

        //Tree -- > 1,2,3,null, 4,5, null
        int x = 5, y = 4;
        one.left = two;
        one.right = three;
//        two.left = four;
        three.left = four;
        three.right = five;

        CousinsInBinaryTree993 ob = new CousinsInBinaryTree993();
        boolean isCousins = ob.isCousins(one, x, y);
        System.out.println(isCousins);

    }

    public boolean isCousins(TreeNode root, int x, int y) {

        return !isSiblings(root, x, y) && isSameLevels(root, x, y);
    }

    public boolean isSameLevels(TreeNode root, int x, int y) {

        return findLevel(root, x, 0) == findLevel(root, y, 0);
    }

    public int findLevel(TreeNode root, int x, int level) {

        if (root == null)
            return -1;

        if (root.val == x) {
            return level;
        }

        int leftLevel = findLevel(root.left, x, level + 1);
        if (leftLevel == -1) {
            return findLevel(root.right, x, level + 1);
        } else {
            return leftLevel;
        }
    }

    public boolean isSiblings(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        // Check children first
        boolean leftSubTreeContainsCousins = isSiblings(root.left, x, y);
        boolean rightSubTreeContainsCousins = isSiblings(root.right, x, y);

        if (leftSubTreeContainsCousins || rightSubTreeContainsCousins)
            return true;

        if (root.left == null || root.right == null) {
            return false;
        }

        // Check for siblings at parent
        if ((root.left.val == x && root.right.val == y) ||
                (root.right.val == x && root.left.val == y)) {
            return true;
        }

        return false;
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
