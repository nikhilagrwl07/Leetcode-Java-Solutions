package leetcodeProblems;

public class LowestCommonAncestorOfBinaryTree236 {
    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1);
        three.setNeighbours(five, one);
        five.setNeighbours(six, two);
        two.setNeighbours(seven, four);
        one.setNeighbours(zero, eight);

        LowestCommonAncestorOfBinaryTree236 ob = new LowestCommonAncestorOfBinaryTree236();
        TreeNode lowestCommonAncestor = ob.lowestCommonAncestor(three, eight, four);
        System.out.println(lowestCommonAncestor.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        TreeNode[] lca = new TreeNode[1];

        dfs(root, p, q, lca);
        return lca[0];
    }

    // Time - O(N) where N is number of nodes in tree
    // Space - O(N) stack frames due to recursion
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode[] lca) {

        if (root == null || lca[0] != null)
            return false;

        // left subtree
        int left = dfs(root.left, p, q, lca) ? 1 : 0;

        // right subtree
        int right = dfs(root.right, p, q, lca) ? 1 : 0;

        // if root equals P or Q
        int equals = (root == p || root == q) ? 1 : 0;

        if (left + right + equals >= 2) {
            lca[0] = root;
            return true;
        }

        return left + right + equals > 0;
    }

    public static class TreeNode {
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
