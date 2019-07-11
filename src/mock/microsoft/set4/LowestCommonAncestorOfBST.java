package mock.microsoft.set4;

public class LowestCommonAncestorOfBST {

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        six.left = two;
        six.right = eight;

        LowestCommonAncestorOfBST ob = new LowestCommonAncestorOfBST();
        TreeNode lowestCommonAncestor = ob.lowestCommonAncestor(six, two, eight);
        System.out.println(lowestCommonAncestor.val);

    }


    // Time Complexity - O(N) in worst case where  N is total nodes in path from root to leaf
    // Space Complexity - O(N) in worst case happens when due to recursion stack
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (q.val < root.val && p.val < root.val && root.left != null) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (q.val > root.val && p.val > root.val && root.right != null) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
