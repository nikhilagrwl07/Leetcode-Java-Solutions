package miscellaneous;

public class CountNodesCompleteBinaryTree {
    public static void main(String[] args) {
        CountNodesCompleteBinaryTree ob = new CountNodesCompleteBinaryTree();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.setNeighbours(two, three);
        two.setNeighbours(four, five);

        three.setNeighbours(six, null);;

        System.out.println(ob.countNodes(one));

    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int[] count = {0};
        dfs(root, count);
        return count[0];
    }

    private void dfs(TreeNode root, int[] maxCount) {
        if (root == null)
            return;

        maxCount[0] += 1;
        dfs(root.left, maxCount);
        dfs(root.right, maxCount);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void setNeighbours(TreeNode l, TreeNode r) {
            this.left = l;
            this.right = r;
        }

    }
}
