/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package miscellaneous;

public class SumDifferenceBetweenOddAndEvenLevelInBinaryTree {
    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
//
        one.setNeighbours(two, three);
        two.setNeighbours(four, five);
        three.setNeighbours(six, null);
//        three.setNeighbours(six, eleven);
        four.setNeighbours(seven, eight);
//        five.setNeighbours(null, ten);

        SumDifferenceBetweenOddAndEvenLevelInBinaryTree ob = new SumDifferenceBetweenOddAndEvenLevelInBinaryTree();
        int sumDifferenceBetweenOddAndEvenLevel = ob.sumDifferenceBetweenOddAndEvenLevel(one);
        System.out.println(sumDifferenceBetweenOddAndEvenLevel);

    }

    public int sumDifferenceBetweenOddAndEvenLevel(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] sum = new int[1]; // index 0 used for even sum and index 1 used for odd sum

        TreeNodeWithLevel rootOfAnode = new TreeNodeWithLevel(0, root);
        summationOfLevels(rootOfAnode, sum);


        return sum[0];
    }

    // DFS approach
    public void summationOfLevels(TreeNodeWithLevel root, int[] sum) {

        if (root == null || root.node == null) {
            return;
        }

        if (root.level % 2 == 0) { // even case
            sum[0] -= root.node.val;
        } else {
            sum[0] += root.node.val;
        }

        TreeNodeWithLevel left = new TreeNodeWithLevel(root.level + 1, root.node.left);
        TreeNodeWithLevel right = new TreeNodeWithLevel(root.level + 1, root.node.right);
        summationOfLevels(left, sum);
        summationOfLevels(right, sum);
    }


    class TreeNodeWithLevel {
        int level;
        TreeNode node;

        public TreeNodeWithLevel(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
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
