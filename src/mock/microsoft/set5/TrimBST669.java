/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package mock.microsoft.set5;

public class TrimBST669 {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        three.setNet(zero, four);
        zero.setNet(null, two);
        two.setNet(one, null);

        TrimBST669 ob = new TrimBST669();
        TreeNode treeNode = ob.trimBST(three, 1, 3);
        System.out.println(treeNode);
    }


    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null)
            return root;

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        // root.val is >=L and <=R
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setNet(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return val + " " + left + " " + right;
        }
    }


}
