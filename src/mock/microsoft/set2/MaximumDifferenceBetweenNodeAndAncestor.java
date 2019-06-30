
package mock.microsoft.set2;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeAndAncestor ob = new MaximumDifferenceBetweenNodeAndAncestor();

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

//        eight.left = three;
//        eight.right = ten;
//
//        three.left = one;
//        three.right = six;
//
//        six.left = four;
//        six.right = seven;
//
//        ten.right = fourteen;
//        fourteen.left = thirteen;

        one.right = two;
        two.right = zero;
        zero.left = three;

        int maxAncestorDiff = ob.maxAncestorDiff(one);
        System.out.println(maxAncestorDiff);


    }

    private int maxV = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {

        pathRootToLeaf(root, new int[5000], 0);
        return maxV;
    }


    public void pathRootToLeaf(TreeNode node, int[] path, int index) {

        if (node == null)
            return;

        path[index] = node.val;

        if (node.left == null && node.right == null) {
            findDiffAndCompare(path, index);
            return;
        }

        pathRootToLeaf(node.left, path, index + 1);
        pathRootToLeaf(node.right, path, index + 1);
    }

    private void findDiffAndCompare(int[] path, int i) {

        if (i < 1) {
            return;
        }

        int min = path[0];
        int max = path[0];


        for (int j = 1; j <= i; j++) {

            min = Math.min(min, path[j]);
            max = Math.max(max, path[j]);

        }
        maxV = Math.max(maxV, Math.abs(min - max));
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
