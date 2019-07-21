/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.LinkedList;

public class CheckCompletenessofBinaryTree958 {
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

        CheckCompletenessofBinaryTree958 ob = new CheckCompletenessofBinaryTree958();
        boolean completeTree = ob.isCompleteTree(one);
        System.out.println(completeTree);

    }

    public boolean isCompleteTree(TreeNode root) {

        if (root == null)
            return true;


        LinkedList<TreeNodeWithPosition> q = new LinkedList<>();
        int index = 0;
        q.add(new TreeNodeWithPosition(root, 1));

        while (index <= q.size() - 1) {

            TreeNodeWithPosition treeNodeWithPosition = q.get(index++);

            if (treeNodeWithPosition.node.left != null) {
                q.add(new TreeNodeWithPosition(treeNodeWithPosition.node.left, treeNodeWithPosition.position * 2));
            }

            if (treeNodeWithPosition.node.right != null) {
                q.add(new TreeNodeWithPosition(treeNodeWithPosition.node.right, treeNodeWithPosition.position * 2 + 1));
            }
        }

        return q.getLast().position == index;
    }

    static class TreeNodeWithPosition {
        TreeNode node;
        int position;

        public TreeNodeWithPosition(TreeNode node, int position) {
            this.node = node;
            this.position = position;
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
