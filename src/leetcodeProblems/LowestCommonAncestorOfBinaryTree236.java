/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

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

        flag = false;
        List<TreeNode> pathOfP = new ArrayList<>();
        pathOfNode(root, p, pathOfP, 0);

        flag = false;
        List<TreeNode> pathOfQ = new ArrayList<>();
        pathOfNode(root, q, pathOfQ, 0);

        int i = 0;
        int j = 0;
        int index = Math.min(pathOfP.size() - 1, pathOfQ.size() - 1);


        TreeNode lastEqual = null;
        while (i <= index && j <= index) {

            if (pathOfP.get(i).val == pathOfQ.get(j).val) {
                lastEqual = pathOfP.get(i);
            }
            i++;
            j++;
        }

        return lastEqual;
    }

    private boolean flag = false;

    public boolean pathOfNode(TreeNode root, TreeNode p, List<TreeNode> path, int index) {

        if (root == null || flag)
            return false;


        path.add(index, root);

        if (root.val == p.val) {
            flag = true;
            return true;
        }

        boolean left = pathOfNode(root.left, p, path, index + 1);
        boolean right = pathOfNode(root.right, p, path, index + 1);
        boolean result = left || right;
        if (!result) {
            path.remove(index);
        }
        return result;
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
